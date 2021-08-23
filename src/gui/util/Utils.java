package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {

		public static Stage currentStage (ActionEvent event) {
			return (Stage) ((Node) event.getSource()).getScene().getWindow();
			
		}
		
		// Método para facilitar a conversão e não ter que ficar repetindo o mesmo código
		// para a conversão de uma string em número inteiro.
		public static Integer tryParseToInt(String str) {
			try {
				return Integer.parseInt(str);
			}
			// pode ser que o conteúdo do str, não seja um número inteiro, um número
			// não válido, caso isso aconteça, será retornado um NULL como exceção.
			catch (NumberFormatException e) {
				return null;
			}
		}
	
}
