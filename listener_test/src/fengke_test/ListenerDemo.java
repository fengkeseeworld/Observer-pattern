package fengke_test;
/**
 * ѧϰ�ܽ�
 * @author ���
 * <br>
 * ͨ��ѧϰDemo1.java�����б�дһ���۲���ģʽ��
 *
 */
public class ListenerDemo {
	//����
	public static void main(String[] args) {
	//������������
	Actor ac=new Actor("��������");
	//���ü�����
	ac.setListenertools(new listenertools() {
		@Override
		public void dorun(Listener listener) {
			listener.setName("������B");
			System.out.println(listener.getName()+"������   "+listener.getActor()+"�ܲ���");
			
		}
		@Override
		public void doeat(Listener listener) {
			listener.setName("������C");
			System.out.println(listener.getName()+"������   "+listener.getActor()+"�Է���");
			
		}
	});
	
	ac.run();
	ac.eat();
	
		
	}

}

/*
 * ��������
 */
class Actor{
	//����һ������
	private String name;
	//���ü�����
	private listenertools listenertools;
	//������
	public Actor(String name) {
		super();
		this.name = name;
	}
	//��ȡ���ֵķ���
	public String getName(){
		return this.name;
	}
	//���ü���
	public void  setListenertools(listenertools lis){
		this.listenertools=lis;
	}
	
	public void run(){
		System.out.println(name+"�ܲ��ˣ�����");
		//������ڼ��������һ�������ڲ��࣬������������Ϣ����
		if(listenertools!=null){
			listenertools.dorun(new Listener(this));
		}
	}
	
	
	public void eat(){
		System.out.println(name+"���˷��ˣ�����");
		//������ڼ��������һ�������ڲ��࣬������������Ϣ����
		if(listenertools!=null){
			listenertools.doeat(new Listener(this));
		}
	}
}
/*
 * ������
 */
class Listener{
	//������
	private String name;
	//����������
	private Actor actor;
	//������
	public Listener(Actor actor){
		super();
		this.actor=actor;
	}
	//��ȡ��������Ϣ
	public String getName(){
		return this.name;
	}
	//��ȡ����������Ϣ
	public Actor getActor() {
		return actor;
	}
	//���ü�������Ϣ
	public void setName(String name){
		this.name=name;
	}
	//���ñ���������Ϣ
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
}
/*
 * ��������
 * 
 * ���ã����������ߺͼ�������������
 */
interface listenertools{
	
	public void dorun(Listener listener);
	
	public void doeat(Listener listener);
	
}

