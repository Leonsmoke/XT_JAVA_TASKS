import services.WriteService;
import services.core.*;
import services.interfaces.CollectionServiceInterface;

public class ServicesApplication {
    CollectionServiceInterface service;

    public static void main(String[] args) {
        ServicesApplication app = new ServicesApplication();
        app.run();
    }

    private void run(){
        System.out.println("Select service to start:\n" +
                "1.Reverse service\n" +
                "2.Directory service\n" +
                "3.Poem service\n" +
                "4.Bracket service\n" +
                "5.Unique words service\n" +
                "0.Exit\n");
        selectService();
        service.start();
    }

    private void selectService(){
        int selectedService = WriteService.getInt();
        switch (selectedService){
            case 1:
                service = new ReverseString();
                break;
            case 2:
                service = new CheckDirectoryService();
                break;
            case 3:
                service = new PoemService();
                break;
            case 4:
                service= new CheckBracketsService();
                break;
            case 5:
                service = new ParseUniqueWordsService();
                break;
            default:
                System.exit(0);
        }
    }
}
