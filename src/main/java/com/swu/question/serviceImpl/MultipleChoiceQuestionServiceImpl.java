package com.swu.question.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swu.question.dao.TextDAO;
import com.swu.question.dao.WordDAO;
import com.swu.question.entity.DistanceAndWord;
import com.swu.question.entity.Distracter;
import com.swu.question.entity.NewWords;
import com.swu.question.entity.Question;
import com.swu.question.entity.QuestionType;
import com.swu.question.entity.Text;
import com.swu.question.entity.Word;
import com.swu.question.service.MultipleChoiceQuestionService;
import com.swu.question.service.TextService;
import com.swu.question.util.Clauses;
import com.swu.question.util.Distance;
import com.swu.question.util.ExcelBean;
import com.swu.question.util.WordExcel;

@Service
@Transactional 
public class MultipleChoiceQuestionServiceImpl implements MultipleChoiceQuestionService {
	
	@Autowired
	private WordDAO wordDao;
	@Autowired
	private TextDAO textDao;
	@Autowired
	private TextService textService;
	
	/**
	 * 获取有生字的句子
	 * @return
	 */
	public List<Question> getQuestionSentence(int textId){
		List<Question> questionList = new ArrayList<Question>();
		Text text = textDao.queryText(textId);
		//文章生字列表
		Set<NewWords> newWordsList = text.getNewWords();
		//获取文章正文内容
		List<String> list = textService.readWordText(textId);
		String content ="";
		for(int i = 0;i<list.size();i++){
			content+=list.get(i);
		}
		//对文章内容进行分句
		String[] sentences = Clauses.getClauses(content);
		//获取含有生字的句子
		for(NewWords newWords : newWordsList){
			for(int i=0;i<sentences.length;i++){
				if(sentences[i].contains(newWords.getWord())){
					Question q = new Question();
					q.setSentence(sentences[i]);
					q.setQuestion(getQuestion(sentences[i],newWords.getWord()));
					q.setAnswer(newWords.getWord());
					questionList.add(q);
					System.out.println(q.getQuestion());
					break;
				}
			}
		}
		return questionList;
	}
	
	/**
	 * 根据给出得的句子和汉字，得到问题
	 * @param sentences eg:我在家。
	 * @param word eg:家
	 * @return eg:我在（）。
	 */
	public String getQuestion(String sentences,String word){
		
		return sentences.replaceFirst(word,"( )");
	}
	/**
	 * 添加默认字库表
	 * @return
	 */
	public void addWords(String path){
		List<Word> wordList = new WordExcel().readWrodExcel(path + "/字库表.xls");
		for(Word w:wordList){
			wordDao.insertWord(w);
		}
	}
	
	@Override
	public List<Question> createMultipleChoiceQuestion(int textId,String path) {
		//从文章中获取问题列表
		List<Question> questionList = getQuestionSentence(textId);
		List<DistanceAndWord> py_distance = new ArrayList<DistanceAndWord>();
		List<DistanceAndWord> bh_distance = new ArrayList<DistanceAndWord>();
		List<DistanceAndWord> bh_rank = new ArrayList<DistanceAndWord>();
		List<DistanceAndWord> py_rank = new ArrayList<DistanceAndWord>();
		
		if(wordDao.getWordList() == null){
			addWords(path);
		}
		
		List<Word> wordList = wordDao.getWordList();
		
		for (Question question : questionList) {
			List<Word> temp = new ArrayList<Word>();
			List<Word> bs = new ArrayList<Word>();
			List<Word> jg = new ArrayList<Word>();
			List<Word> py = new ArrayList<Word>();
			List<Word> bh = new ArrayList<Word>();
			if (!bs.isEmpty()) {
				bs.clear();
			}
			if (!jg.isEmpty()) {
				jg.clear();
			}
			if (!py.isEmpty()) {
				py.clear();
			}
			if (!bh.isEmpty()) {
				bh.clear();
			}
			if (!py_distance.isEmpty()) {
				py_distance.clear();
			}
			if (!bh_distance.isEmpty()) {
				bh_distance.clear();
			}
			if (!bh_rank.isEmpty()) {
				bh_rank.clear();
			}
			if (!py_rank.isEmpty()) {
				py_rank.clear();
			}

			String newWord = question.getAnswer();
			Word word =null;
			try {
				word = wordDao.getWord(newWord.trim());
			} catch (Exception e1) {
				System.out.println("---->字库中没有\""+newWord+"\"这个字！");
			}
			
			if(word!=null){ 
				String word_bh = word.getBh();
				String word_py = word.getPy();
				String word_bs = word.getBs();
				String word_jg = word.getJg();
				for (Word w : wordList) {
					if (w.getBs().equals(word_bs) && !(w.getWord().equals(newWord))) {
						bs.add(w);
						System.out.println("bs:" + bs.size() + "--->" + newWord
								+ "-->" + w.getWord());
					}
				}
				if (bs.size() == 0) {
					for (Word w : wordList) {
						if (w.getJg().equals(word_jg)
								&& !(w.getWord().equals(newWord))) {
							jg.add(w);
							System.out.println("---部首大小为零---");
						}
					}
				} else if (bs.size() >= 1 && bs.size() <= 4) {
					for(Word w : bs)
						jg.add(w);
					System.out.println("1<=bs.size<=4");
				} else if (bs.size() > 4) {
					for (Word w : bs) {
						if (w.getJg().equals(word_jg)
								&& !(w.getWord().equals(newWord))) {
							jg.add(w);
							System.out.println("jg.sixe-->" + jg.size()
									+ "  newWord--->" + newWord + " word-->"
									+ w.getWord());
						}
					}
					System.out.println("jg大小:" + jg.size());
				}
				
				// bs-->jg比较完成 下面进行py比较
				if(jg.size()==0){
					for(int i=0;i<bs.size();i++){
						if(i<=4){
							Word word1 =(Word) bs.get(i);
							temp.add(word1);
						}
					}
				}else if (jg.size() >= 1 && jg.size() <= 4) {
					for(Word w : jg)
						temp.add(w);
				} else if (jg.size() > 4) {
					for (Word w : jg) {
	
						if (!(w.getWord().equals(newWord))) {
							DistanceAndWord distanceAndWord = new DistanceAndWord();
							int distance = Distance.getEditDistance(w.getPy(),
									word_py);
							distanceAndWord.setDistance(distance);
							distanceAndWord.setWord(w);
							py_distance.add(distanceAndWord);
						}
					}
				}

				//py结束 下面比较bh
				if (py_distance.size() >= 1 && py_distance.size() <= 4) {
					for (DistanceAndWord daw : py_distance) {
						temp.add(daw.getWord());
					}
				} else if (py_distance.size() > 4) {
					
					//  1.排序 2.取前10个
					 
					Collections.sort(py_distance);
					py_rank = py_distance;
	
					for (int i = 0; i < py_rank.size(); i++) {
						if (i <= 10) {
							DistanceAndWord daw = py_rank.get(i);
							py.add(daw.getWord());
						} else {
							break;
						}
	
					}
					for (Word w : py) {
						if (!(w.getWord().equals(newWord))) {
							DistanceAndWord distanceAndWord = new DistanceAndWord();
							int distance = Distance.getEditDistance(w.getBh(),
									word_bh);
							distanceAndWord.setDistance(distance);
							distanceAndWord.setWord(w);
							bh_distance.add(distanceAndWord);
						}
					}
				}
				
				if (bh_distance.size() >= 1 && bh_distance.size() <= 4) {
					for (DistanceAndWord daw : bh_distance) {
						temp.add(daw.getWord());
					}
				} else if (bh_distance.size() > 4) {
					
					// 排序取前四个
					
					Collections.sort(bh_distance);
					bh_rank = bh_distance;
					for (int i = 0; i < bh_rank.size(); i++) {
						if (i <= 4) {
							DistanceAndWord daw = bh_rank.get(i);
							temp.add(daw.getWord());
						} else {
							break;
						}
					}
					System.out.println("tmpe.size--->" + temp.size());
					System.out.println("py_distance.size--->" + py_distance.size());
				}
				
				//如果产生候选项个数小于5时，差的候选项随机产生
				Random random = new Random();
				if(temp.size()<5){
					for(int indexnum=temp.size();indexnum<5;indexnum++){
						boolean myflags = true;
						while(myflags){
							Word randomWord = wordList.get(Math.abs(random.nextInt())%(wordList.size()));
							boolean myflags1 = true;
							for(Word w : temp){
								if(w.getWord().equals(randomWord.getWord()))
									myflags1 = false;
							}
							if(myflags1){
								temp.add(randomWord);
								myflags = false;
							}
						}
					}
				}
			}
			Set<Distracter> distracters = new HashSet<Distracter>();
			for(Word w:temp){
				Distracter distracter = new Distracter();
				distracter.setDistracter(w.getWord());
				distracters.add(distracter);
			}
			question.setDistracter(distracters);
		}
		return questionList;
	}
}
