package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {

		public static Stage currentStage (ActionEvent event) {
			return (Stage) ((Node) event.getSource()).getScene().getWindow();
			
		}
		
		// M�todo para facilitar a convers�o e n�o ter que ficar repetindo o mesmo c�digo
		// para a convers�o de uma string em n�mero inteiro.
		public static Integer tryParseToInt(String str) {
			try {
				return Integer.parseInt(str);
			}
			// pode ser que o conte�do do str, n�o seja um n�mero inteiro, um n�mero
			// n�o v�lido, caso isso aconte�a, ser� retornado um NULL como exce��o.
			catch (NumberFormatException e) {
				return null;
			}
		}
	
}
