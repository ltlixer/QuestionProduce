package com.swu.question.daoImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.question.dao.WordDAO;
import com.swu.question.entity.Word;

@Repository
public class WordDAOImpl implements WordDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertWord(Word word) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(word);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateWord(Word word) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(word);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Word getWord(String word) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery("from Word w where  w.word=?");
		q.setParameter(0, word);
		List<Word> words = q.list();
		if (words != null && words.size() > 0)
			return words.get(0);
		else
			return null;
	}

	@Override
	public List<Word> getWordList() {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery("from Word");
		List<Word> words = q.list();
		if (words != null && words.size() > 0)
			return words;
		else
			return null;
	}

	@Override
	public List<Word> getWordListByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery("from Word w limit ?,?");
		q.setParameter(0, map.get("startNumber"));
		q.setParameter(1, map.get("perNumber"));
		List<Word> words = q.list();
		if (words != null)
			return words;
		else
			return null;
	}

	@Override
	public int getWordCount() {
		// TODO Auto-generaQuery q = sessionFactory.getCurrentSession().createQuery("from Word");
		Query q = sessionFactory.getCurrentSession().createQuery("from Word");
		List<Word> words = q.list();
		if (words != null)
			return words.size();
		else
			return 0;
	}

	@Override
	public void deletWord() {
		// TODO Auto-generated method stub
		Query query= sessionFactory.getCurrentSession().createQuery("delete from Word where 1=1");
		query.executeUpdate();
	}

	@Override
	public List<Word> getWordListByFrequency(String grade) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery("from Word w where w.frequency=?");
		q.setParameter(0, grade);
		List<Word> words = q.list();
		if (words != null && words.size() > 0)
			return words;
		else
			return null;
	}

	@Override
	public List<Word> getWordListByBS(String bs) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery("from Word w where w.bs=:bs");
		q.setParameter("bs", bs);
		return q.list();
	}
	@Override
	public List<Word> getWordListByJG(String jg) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery("from Word w where w.jg=:jg");
		q.setParameter("jg", jg);
		return q.list();
	}
}
