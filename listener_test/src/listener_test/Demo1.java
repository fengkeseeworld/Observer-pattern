package listener_test;
/**
 * �۲���ģʽ
 * @author ���
 *	�˽�۲���ģʽ�����л���
 */
public class Demo1 {
	
	public static void main(String[] args) {
		Person p=new Person();
		//ע�������
		p.register(new MyPersonListener() {
			
			@Override
			public void dorun(Event e) {
				Person p=e.getsource();
				System.out.println(p+"�ܲ��ˣ�����");
			}
			
			@Override
			public void doeat(Event e) {
				Person p=e.getsource();
				System.out.println(p+"�Է��ˣ�����");
			}
		});
		
		p.eat();
		p.run();
		System.out.println(p);
	}
	
	

}

/*
 * �۲��� Person
 */
class Person{
	//��������
	private MyPersonListener listener=null;
	
	//�ܵĶ���
	public void run() {
		
		if(listener!=null){
			listener.dorun(new Event(this));
			System.out.println("�ܵ��¼�������");
		}
	}
	//�ԵĶ���
	public void eat(){
		if(listener!=null){
			listener.doeat(new Event(this));
			System.out.println("�Ե��¼�������");
		}
	}
	//ָ��
	public void register(MyPersonListener listener){
		this.listener=listener;
	}
}

/*
 * �����Ķ���---�¼�Դ
 */
class Event{
	private Person source;
	public Event(Person person){
		this.source=person;
	}
	public Person getsource(){
		return this.source;
	}
	
}


/*
 * �����Ľӿ�
 */
interface MyPersonListener{
	public void dorun(Event e);
	public void doeat(Event e);
}
