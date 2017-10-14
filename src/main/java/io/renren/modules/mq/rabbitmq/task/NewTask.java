package io.renren.modules.mq.rabbitmq.task;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * 实现任务分发
 * 一个队列的优点就是很容易处理并行化的工作能力，但是如果我们积累了大量的工作，
 * 我们就需要更多的工作者来处理，这里就要采用分布机制了。
 * @author asus-1
 *
 */
public class NewTask {
    private static final String TASK_QUEUE_NAME="task_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        //设置RabbitMQ相关信息
        factory.setHost("localhost");
        factory.setUsername("guest");
        Connection connection=factory.newConnection();
        Channel channel=connection.createChannel();
        channel.queueDeclare(TASK_QUEUE_NAME,true,false,false,null);
        //分发信息
        for (int i=0;i<10;i++){
            String message="Hello RabbitMQ"+i;
            channel.basicPublish("",TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
            System.out.println("NewTask send '"+message+"'");
        }
        channel.close();
        connection.close();
    }
}