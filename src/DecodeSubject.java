
public class DecodeSubject {
	private String input;
	private String folderLocation = "";
	
	public DecodeSubject(String input) {
		this.input = input;
	}
	
	public String toString() {
		folderLocation = "\\\\monkeycloud\\database\\";
		if (input.substring(0, input.indexOf('-')).equals("MJ")) {
			
		}else if (input.substring(0, input.indexOf('-')).equals("MH")) {
			
		}else if (input.substring(0, input.indexOf('-')).equals("PJ")) {
			
		}else if (input.substring(0, input.indexOf('-')).equals("PH")) {
			
		}
		return "";
	}
}
