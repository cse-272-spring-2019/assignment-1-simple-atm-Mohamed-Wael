/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Mohamed Wael
 */
public class ATM extends Application implements EventHandler<ActionEvent> {
    Stage window;
    int i = -1;
    String[] history = new String[100];
    Scene login,home,depositscene,withdrawscene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Tasks task = new Tasks();
        
        //Login Scene
        Label label1= new Label("Enter Card Number");
        Label label2 = new Label();
        TextField number = new TextField();
        Button button1 = new Button("Enter");
        button1.setOnAction((ActionEvent event) -> {
            Login verify = new Login();
            boolean valid = verify.validate(number.getText());
            if(valid){
                window.setScene(home);
            }
            else
                label2.setText("Invalid Number");
        });
        GridPane grid1 = new GridPane();
        grid1.setPadding(new Insets(10,10,10,10)); 
        grid1.setVgap(20);
        grid1.setHgap(20);
        grid1.add(label1,0,0);
        grid1.add(number,1,0);
        grid1.add(button1,0,1);
        grid1.add(label2,1,1);
        login = new Scene(grid1,400,400);
        
        
        //Home Scene
        Button withdraw = new Button("Withdraw");
        Button deposit = new Button("Deposit");
        Button balance = new Button("Balance Inquiry");
        Button previous = new Button("Previous");
        Button next = new Button("Next");
        Label outcome = new Label();
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10,10,10,10)); 
        grid2.setVgap(20);
        grid2.setHgap(20);
        grid2.add(withdraw,0,0);
        grid2.add(deposit,0,1);
        grid2.add(balance,0,2);
        grid2.add(previous,0,3);
        grid2.add(next,0,4);
        grid2.add(outcome,1,2);
        home = new Scene(grid2,500,500);
        withdraw.setOnAction(e -> {
            window.setScene(withdrawscene);
            outcome.setText("");
            
        });
        deposit.setOnAction(e -> {
            window.setScene(depositscene);
            outcome.setText("");
        });
        balance.setOnAction(e ->{
            String balancevalue = task.getbalance();
            outcome.setText(balancevalue);
        });
        previous.setOnAction(e-> {
            outcome.setText(history[i]);
            i--;
        });
        next.setOnAction(e->{
            if(history[i+2]!=null){
                outcome.setText(history[i+2]);
                i++;
            }
        });
        
        //Withdraw Scene
        Label wlabel = new Label("Enter Amount to Withdraw");
        TextField wamount = new TextField();
        Button wok = new Button("Ok");
        Button wback = new Button("Back");
        Label error = new Label();
        GridPane grid3 = new GridPane();
        grid3.setPadding(new Insets(10,10,10,10)); 
        grid3.setVgap(20);
        grid3.setHgap(20);
        grid3.add(wlabel,0,0);
        grid3.add(wamount,1,0);
        grid3.add(wback,0,1);
        grid3.add(wok,1,1);
        grid3.add(error,1,2);
        withdrawscene = new Scene(grid3,600,600);
        wback.setOnAction(e -> {
            window.setScene(home);
            error.setText("");
            wamount.clear();
        });
        wok.setOnAction(e -> {
            int f = task.withdrawalcheck(wamount.getText());
            if(f==0)
                error.setText("Unavailable Amount");
            else{
                window.setScene(home);
                i++;
                history[i] = ("Withdraw:"+wamount.getText());
                error.setText("");
                wamount.clear();
            }
        });
        
        
        //Deposit Scene
        Label dlabel = new Label("Enter Amount to Deposit");
        TextField damount = new TextField();
        Button dok = new Button("Ok");
        Button dback = new Button("Back");
        GridPane grid4 = new GridPane();
        grid4.setPadding(new Insets(10,10,10,10)); 
        grid4.setVgap(20);
        grid4.setHgap(20);
        grid4.add(dlabel,0,0);
        grid4.add(damount,1,0);
        grid4.add(dback,0,1);
        grid4.add(dok,1,1);
        depositscene = new Scene(grid4,600,600);
        dback.setOnAction(e -> {
            window.setScene(home);
            damount.clear();
        });
        dok.setOnAction(e -> {
            task.deposit(damount.getText());
            i++;
            history[i] = ("Deposit: "+damount.getText());
            window.setScene(home);
            damount.clear();
        });
        
        window.setScene(login);
        window.setTitle("ATM");
        window.show();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
