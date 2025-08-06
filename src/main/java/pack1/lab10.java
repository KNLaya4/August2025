package pack1;

public class lab10 {
	public void toCheckPostive(String str) {
		boolean isPositive = true;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) <= str.charAt(i - 1)) {
				isPositive = false;
				break;
			}
		}

		if (isPositive) {
			System.out.println(str + " is a positive string");
		} else {
			System.out.println(str + " is NOT a positive string");
		}
	}

	public static void main(String[] args) {
		lab10 obj = new lab10();
		obj.toCheckPostive("ANT");
		obj.toCheckPostive("zyx");
	}
}