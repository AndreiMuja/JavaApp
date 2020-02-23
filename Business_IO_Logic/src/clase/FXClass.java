package clase;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FXClass extends Application{
	
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {
		String newLine=System.getProperty("line.separator");
		OperatiiInOutFisier of=new OperatiiInOutFisier();
		
		Label serie=new Label("Serie");
		Label tonaj=new Label("Tonaj");
		Label marca=new Label("Marca");
		Label capacitate=new Label("Capacitate");
		Label alternativ=new Label("CNP/Serie");
		Button citire=new Button("Citire");
		citire.setOnAction(e->{
			of.citesteObiecteDinFisierText("AvionPasageri01.txt");
			for(Object o:of.getListaObiecte()){
				if(o instanceof AvionPasageri){
					AvionPasageri ap=(AvionPasageri) o;
					serie.setText(serie.getText()+newLine+ap.getSerie());
					tonaj.setText(tonaj.getText()+newLine+ap.getTonaj());
					marca.setText(marca.getText()+newLine+ap.getMarca());
					capacitate.setText(capacitate.getText()+newLine+ap.getCapacitate());
					String s="";
					for(String sir:ap.cnpPasageri){
						s+=sir;
					}
					alternativ.setText(alternativ.getText()+newLine+s);
				}
				if(o instanceof AvionCargo){
					AvionCargo ag=(AvionCargo) o;
					serie.setText(serie.getText()+newLine+ag.getSerie());
					tonaj.setText(tonaj.getText()+newLine+ag.getTonaj());
					marca.setText(marca.getText()+newLine+ag.getMarca());
					capacitate.setText(capacitate.getText()+newLine+ag.getCapacitate());
					String s="";
					for(String sir:ag.serieMarfuri){
						s+=sir;
					}
					alternativ.setText(alternativ.getText()+newLine+s);
				}
			}
		});
		Button transmite=new Button("Transmite");
		transmite.setOnAction(e->{
			for(Object o:of.getListaObiecte()){
				try{
					Client c=new Client();
					c.transmite(o);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		GridPane gp=new GridPane();
		gp.setHgap(5);
		gp.setVgap(5);
		gp.setPadding(new Insets(0,0,0,0));
		GridPane.setConstraints(citire, 0, 0);
		GridPane.setConstraints(transmite, 5, 0);
		GridPane.setConstraints(serie, 0, 1);
		GridPane.setConstraints(tonaj, 1, 1);
		GridPane.setConstraints(marca, 3, 1);
		GridPane.setConstraints(capacitate, 4, 1);
		GridPane.setConstraints(alternativ, 5, 1);
		gp.getChildren().addAll(serie,tonaj,marca,capacitate,alternativ,citire,transmite);
		Scene scena=new Scene(gp,600,800);
		window.setScene(scena);
		window.show();
	}
}
