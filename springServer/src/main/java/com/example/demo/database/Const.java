package com.example.demo.database;

public class Const {
    public static final String USER_TABLE = "user";
    public static final String USERS_ID = "idUser";
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_EMAIL = "email";
    public static final String USER_BIRTHDATE = "birthDate";
    public static final String USER_BALANCE = "balance";
    public static final String USER_PHONE = "telephoneNumber";

    public static final String CLUSTER_TABLE = "cluster";
    public static final String CLUSTER_ID = "idCluster";
    public static final String CLUSTER_NAME = "name";
    public static final String CLUSTER_PARTICIPANT_COUNTER = "participantCounter";
    public static final String CLUSTER_GOAL = "goal";

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
    public static final String FUNDRAISING_ID = "idFundraising";
    public static final String FUNDRAISING_GOAL = "goal";
    public static final String FUNDRAISING_Goal_Allowed = "isGoalAllowed";
    public static final String FUNDRAISING_NAME = "name";
    public static final String FUNDRAISING_EXPIRE = "expire";
    public static final String FUNDRAISING_FUND_SUM = "sum";

    public static final String TRANSACTION_TABLE = "transaction";
    public static final String TRANSACTION_ID = "idTransaction";
    public static final String TRANSACTION_TYPE = "type";
    public static final String TRANSACTION_SUM = "sum";
    public static final String TRANSACTION_CODE = "code";
    public static final String TRANSACTION_TIME = "time";
}