package com.swu.question.experiment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swu.question.entity.Distracter;
import com.swu.question.entity.Question;
import com.swu.question.service.MultipleChoiceQuestionService;

@ContextConfiguration(locations={"classpath:servlet-context.xml","classpath:root-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DistractorGeneratorTest {

	@Resource
	private MultipleChoiceQuestionService multipleChoiceQuestionService;
	
	@Test
	public void testMultipleChoiceQuestion(){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ltlix\\Desktop\\test-question-generater.txt", true));
			
			List<Question> questionList1 = multipleChoiceQuestionService.generateChoiceQuestion1(357);
			writer.write("1\r\n");
			for(Question question:questionList1){
				Set<Distracter> distracters = question.getDistracter();
				for(Distracter distracter:distracters)
					writer.write(question.getAnswer()+"-->"+distracter.getDistracter()+"\r\n");
					//System.out.println(question.getAnswer()+"-->"+distracter.getDistracter());
			}
			List<Question> questionList2 = multipleChoiceQuestionService.generateChoiceQuestion2(357);
			writer.write("2\r\n");
			for(Question question:questionList2){
				Set<Distracter> distracters = question.getDistracter();
				for(Distracter distracter:distracters)
					writer.write(question.getAnswer()+"-->"+distracter.getDistracter()+"\r\n");
				//System.out.println(question.getAnswer()+"-->"+distracter.getDistracter());
			}
			List<Question> questionList3 = multipleChoiceQuestionService.generateChoiceQuestion3(357);
			writer.write("3\r\n");
			for(Question question:questionList3){
				Set<Distracter> distracters = question.getDistracter();
				for(Distracter distracter:distracters)
					writer.write(question.getAnswer()+"-->"+distracter.getDistracter()+"\r\n");
				//System.out.println(question.getAnswer()+"-->"+distracter.getDistracter());
			}
			List<Question> questionList4 = multipleChoiceQuestionService.generateChoiceQuestion4(357);
			writer.write("4\r\n");
			for(Question question:questionList4){
				Set<Distracter> distracters = question.getDistracter();
				for(Distracter distracter:distracters)
					writer.write(question.getAnswer()+"-->"+distracter.getDistracter()+"\r\n");
				//System.out.println(question.getAnswer()+"-->"+distracter.getDistracter());
			}
			writer.close();
		}catch(Exception e){

		}
	}
	
	@Test
	public void testWordDAO(){
	}

}
