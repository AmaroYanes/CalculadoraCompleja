package dad.javafx.calc;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class CalculadoraApp extends Application{
	
	private Alert alert;
	private TextField primerReal,segundoReal,primerImaginario,segundoImaginario,resultadoReal,resultadoImaginario;
	private ComboBox<Character> operacion;
	private Complejo primero,segundo,resultado;
	
	
	public void start(Stage primaryStage) throws Exception {
		
		primerReal = new TextField("0");
		segundoReal = new TextField("0");
		primerImaginario = new TextField("0");
		segundoImaginario = new TextField("0");
		resultadoReal = new TextField("0");
		resultadoReal.setDisable(true);
		resultadoImaginario = new TextField("0");
		resultadoImaginario.setDisable(true);
		primero = new Complejo();
		segundo = new Complejo();
		resultado = new Complejo();

		operacion = new ComboBox<Character>();
		operacion.getItems().addAll('+','-','*','/');
			
		Separator separador = new Separator();
		
		HBox primerBox = new HBox(5,primerReal,new Label(","),primerImaginario,new Label("i"));
		primerBox.setAlignment(Pos.CENTER);
		
		HBox segundoBox = new HBox(5,segundoReal,new Label(","),segundoImaginario,new Label("i"));
		segundoBox.setAlignment(Pos.CENTER);
		
		HBox resultadoBox = new HBox(5,resultadoReal,new Label(","),resultadoImaginario,new Label("i"));
		resultadoBox.setAlignment(Pos.CENTER);
	
		VBox combo = new VBox(5,operacion);
		combo.setAlignment(Pos.CENTER);
		
		VBox operaciones = new VBox(5,primerBox,segundoBox,separador ,resultadoBox);
		operaciones.setAlignment(Pos.CENTER);
		operaciones.setMaxWidth(120);
		
		HBox root = new HBox(5,combo,operaciones);
		root.setAlignment(Pos.CENTER);
		
		operacion.setOnAction(e -> onOperacionAction(e));
		
		
		//bindeos
		/*resultadoImaginario.textProperty().bind(
				Bindings
				.when(operacion.valueProperty().isEqualTo('+'))
				.then(primerImaginario.tex)
				
				);
		*/
		Scene scene = new Scene(root,320,200);
		
		primaryStage.setTitle("Calculadora Compleja");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		alert = new Alert(AlertType.ERROR);
		alert.setTitle("Calculadora Compleja");
		alert.setHeaderText("ERROR");
	}
	
	private void onOperacionAction(ActionEvent e) {
		try {
			
			primero.setReal(Double.parseDouble(primerReal.getText()));
			primero.setImaginario(Double.parseDouble(primerImaginario.getText()));
			segundo.setReal(Double.parseDouble(segundoReal.getText()));
			segundo.setImaginario(Double.parseDouble(segundoImaginario.getText()));
			
			switch(operacion.getValue()) {
				case '+':
					resultado = primero.add(segundo);
					break;
				case '-':
					resultado = primero.sustract(segundo);
					break;
				case '*':
					resultado = primero.multiply(segundo);
					break;
				case '/':
					resultado = primero.divide(segundo);
					break;
			}
			resultadoReal.setText(resultado.getReal()+"");
			resultadoImaginario.setText(resultado.getImaginario()+"");
		} catch (NumberFormatException e1) {
			alert.setContentText("Numero no bueno");
			alert.showAndWait();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
