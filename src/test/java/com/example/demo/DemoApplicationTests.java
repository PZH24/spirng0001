package com.example.demo;

import com.example.demo.iml.MessageServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DemoApplicationTests {

	@Resource(name = "Msg")
	private MessageServiceImp queueProducer;
	@Test
	public void testSend() throws Exception {
		for (int x = 0; x < 10; x++) {
			this.queueProducer.sendMessage("study - " + x);
		}
	}
	@Resource(name = "TopicMsgService")
	private MessageServiceImp topicProducer;
	@Test
	public void testTopicSend() throws Exception {
		for (int x = 0; x < 5; x++) {
			this.topicProducer.sendMessage("TopicStudy - " + x);
		}
	}
}

