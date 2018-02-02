package com.kodilla.good.patterns.challenges;

public class UsersProcessor implements ProductOrderServiceInterface {
    private CreateProductOrderInterface createUser;
    private CheckProductOrderExistenceInterface checkUserExistence;
    private StoreProductOrderInterface storeUser;
    private DeleteProductOrderInterface deleteUser;
    private LogInInterface logIn;
    private LogOutInterface logOut;
    private ProductOrderBehaviorReaderInterface collectUserBehavior;
    private ShowUserOrdersHistoryInterface showUserOrdersHistory;

    private User user;
    private boolean userWantAccount;
    private boolean isUserAccountCreated;
    private boolean userWantNotification;

    UsersProcessor() {
        createUser = new CreateProductOrder();
        checkUserExistence = new CheckProductOrderExistence();
        storeUser = new StoreProductOrder();
        deleteUser = new DeleteProductOrder();
        logIn = new LogIn();
        logOut = new LogOut();
        collectUserBehavior = new ProductOrderBehaviorReader();
        showUserOrdersHistory = new ShowUserOrdersHistory();
    }

    @Override
    public ProductOrderDto process(ProductOrderDto productOrderDto) {
        collectUserBehavior.process(productOrderDto);
        if ( ! productOrderDto.getUserWantAccount()) {
            productOrderDto.setUser(new User("John", "O`Connor"));
            productOrderDto.setAutoOrderId();
        } else {
            LogIn loginClass = new LogIn();
            productOrderDto.setUser(loginClass.process(productOrderDto).getUser());
            productOrderDto.setAutoOrderId();
        }
        if (productOrderDto.getUserWantAccount()) {
            checkUserExistence.process(productOrderDto);
        }
        if ( ! productOrderDto.getUserExist()) {
            createUser.process(productOrderDto);
        }
        return productOrderDto;
    }
}
