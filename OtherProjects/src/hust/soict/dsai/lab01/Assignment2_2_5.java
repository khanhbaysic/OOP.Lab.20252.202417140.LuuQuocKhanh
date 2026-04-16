package ICT;
import javax.swing.JOptionPane;
public class Assignment2_2_5 {

	public static void main(String[] args) {
		String strNum1, strNum2;
		strNum1 = JOptionPane.showInputDialog(null, "Input the first number: ");
		double num1 = Double.parseDouble(strNum1);
		strNum2 = JOptionPane.showInputDialog(null,"Input the second number ");
		double num2 = Double.parseDouble(strNum2);
		double sum = num1 + num2;
		double difference = num1 - num2;
		double product = num1 * num2;
		String result = "Sum: " + sum + "\nDifference: " + difference + "\nProduct: " + product;
		if(num2 == 0) {
			result += "\nQuotient: invalid";
		}else {
			double quotient = num1 / num2;
			result += "\nQuotient: " + quotient;
		}
		JOptionPane.showMessageDialog(null, result);
	}

}
