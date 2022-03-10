package extend;

public class DMBCellPhoneEx {
	public static void main(String[] args) {
		DMBCellPhone dmb = new DMBCellPhone();
		dmb.model = "SAMSUNG";
		dmb.color = "Black";
		dmb.channel = 7;
		
		dmb.powerOnOff();
		dmb.turnOn();
		dmb.changeChannel(11);
		dmb.turnOff();
		dmb.bell();
		dmb.sendVoice("Hello");
		dmb.receiveVoice("OK, Hello");
		dmb.hangUp();
	}
}
