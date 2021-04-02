package com.example.demo.database;

public class Const {
    public static final String USER_TABLE = "user";
    public static final String USERS_ID = "memberId";
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_EMAIL = "email";
    public static final String USER_BIRTHDATE = "birthdate";
//    public static final String USER_BALANCE = "balance";
    public static final String USER_PHONE = "telephone";
    public static final String USER_CLUSTERS = "clusters";
    public static final String USER_PERMISSION = "userPermissionOnClusterId";
    public static final String USER_CARDS = "userCards";

    public static final String CLUSTER_TABLE = "cluster";
    public static final String CLUSTER_ID = "clusterId";
    public static final String CLUSTER_NAME = "name";
    public static final String CLUSTER_PARTICIPANT_COUNTER = "participantCounter";
    public static final String CLUSTER_GOAL = "goal";
    public static final String CLUSTER_USERS = "users";
    public static final String CLUSTER_FUNDRAISINGS = "fundraisings";

    public static final String CONNECTION_TABLE = "connection";
    public static final String CONNECTION_ID = "idConnection";
    public static final String CONNECTION_USER_ID = "idUser";
    public static final String CONNECTION_CLUSTER_ID = "idCluster";

    public static final String CARD_TABLE = "cards";
    public static final String CARD_NUMBER = "cardNumber";
    public static final String CARD_EXPIRE = "cardExpire";
    public static final String CARD_HOLDER_NAME = "cardHolderName";
    public static final String CARD_HOLDER_SURNAME = "cardHolderSurname";
    public static final String CARD_ID = "cardId";
    public static final String CARD_CVC = "cvcCode";

    public static final String FUNDRAISING_TABLE = "fundraising";
    public static final String FUNDRAISING_ID = "fundraisingId";
    public static final String FUNDRAISING_GOAL = "goal";
    public static final String FUNDRAISING_Goal_Allowed = "isGoalAllowed";
    public static final String FUNDRAISING_NAME = "fundraisingName";
    public static final String FUNDRAISING_EXPIRE = "fundraisingExpire";
    public static final String FUNDRAISING_FUND_SUM = "currentFundSum";
    public static final String FUNDRAISING_TRANSACTIONS = "transactionList";

    public static final String TRANSACTION_TABLE = "transaction";
    public static final String TRANSACTION_ID = "transactionId";
    public static final String TRANSACTION_TYPE = "transactionType";
    public static final String TRANSACTION_SUM = "transactionSum";
    public static final String TRANSACTION_CODE = "transactionCode";
    public static final String TRANSACTION_TIME = "transactionTime";
}