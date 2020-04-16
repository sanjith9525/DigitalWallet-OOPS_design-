
import java.util.*;
class Driver {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        WalletManager wm = new WalletManager();

        while(true) {
            String command = sc.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];
            switch (commandType) {
                case "CreateWallet" :
                    wm.creatUser(commands[1], Double.parseDouble(commands[2]));
                break;

                case "Overview" :
                    wm.printOverview();
                break;

                case "TransferMoney" :
                    wm.transact(commands[1], commands[2], Double.parseDouble(commands[3]));
                break;

                case "Statement" :
                    wm.printStatement(commands[1]);
                break;

                case "Offer2" :
                    wm.offerTwo();
                break;

                default :

                break;

            }
        }

    }
}