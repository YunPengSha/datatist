package cn.yun.Interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public  class MyInterceptor extends AbstractPhaseInterceptor<Message>{

	public MyInterceptor() {
		super(Phase.RECEIVE);
		// TODO Auto-generated constructor stub
	}

	public void handleMessage(Message arg0) throws Fault {
		// TODO Auto-generated method stub
		System.out.println("MyInterceptor.handleMessage()");
	}

}
