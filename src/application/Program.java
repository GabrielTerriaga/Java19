package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {

		Account acc = new Account(1001, "Alex", 0.0);

		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

		// UPCASTING
		// serve para atribuir uma sub classe para uma super classe

		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
	
		// DOWNCASTING
		// a conversão não é natural precisa ser feito um casting manual colocando entre parenteses o tipo da classe
		/* se eu estiver usando uma classe do tipo account com UPCASTING
		 * eu não consigo acessar um parametro da subclasse se ela contem um UPCASTING
		 * ai que entra o DOWNCASTING, para poder acessar os parametros
		*/
		
		BusinessAccount acc4 = (BusinessAccount)acc2;
		acc4.loan(100.0);
		
		// SIMULANDO UM ERRO DE COMPILAÇÃO, CUIDADO AO INSTANCIAR AS DOWNCASTING, O COMPILADOR NAO VAI IDENTIFICAR, APENAS QUANDO EXECUTAR O CODIGO.
		// -> BusinessAccount acc5 = (BusinessAccount)acc3;
		// TESTANDO SE O OBJ REALMENTE É DO TIPO QUE FOI INFORMADO
		
		//INSTANCEOF testa se é instancia da classe
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}
		
		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
	}
}
