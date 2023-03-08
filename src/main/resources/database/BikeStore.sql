/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     6/3/2023 21:04:02                            */
/*==============================================================*/


drop index if exists EXUCUTER_FK;

drop index if exists AUDIT_PK;

drop table if exists AUDIT;

drop index if exists BRANDS_PK;

drop table if exists BRANDS;

drop index if exists CATEGORIES_PK;

drop table if exists CATEGORIES;

drop index if exists CUSTOMERS_PK;

drop table if exists CUSTOMERS;

drop index if exists STORE_ORDERS_FK;

drop index if exists COSTOMER_ORDERS_FK;

drop index if exists STAFF_ORDERS_FK;

drop index if exists ORDERS_PK;

drop table if exists ORDERS;

drop index if exists PRODUCTS_ORDERS_FK;

drop index if exists ORDERS_PRODUCTS_FK;

drop index if exists ORDER_ITEMS_PK;

drop table if exists ORDER_ITEMS;

drop index if exists CATEGORY_PRODUCTS_FK;

drop index if exists BRAND_PRODUCTS_FK;

drop index if exists PRODUCTS_PK;

drop table if exists PRODUCTS;

drop index if exists RELATIONSHIP_13_FK;

drop index if exists MANAGER_FK;

drop index if exists STAFFS_PK;

drop table if exists STAFFS;

drop index if exists STOCKS_ORDERS_FK;

drop index if exists PRODUCTS_STOCK_FK;

drop index if exists STOCKS_PK;

drop table if exists STOCKS;

drop index if exists STORES_PK;

drop table if exists STORES;

drop index if exists USERS_PK;

drop table if exists USERS;

drop index if exists CUSTOMERVIP_FK;

drop index if exists VIP_CUSTOMERS_PK;

drop table if exists VIP_CUSTOMERS;

/*==============================================================*/
/* Table: AUDIT                                                 */
/*==============================================================*/
create table AUDIT (
   ID                   SERIAL               not null,
   DATE                 DATE                 null,
   QUERY                VARCHAR(255)         null,
   EXECUTED_BY          INT4                 null,
   constraint PK_AUDIT primary key (ID)
);

/*==============================================================*/
/* Index: AUDIT_PK                                              */
/*==============================================================*/
create unique index AUDIT_PK on AUDIT (
ID
);

/*==============================================================*/
/* Index: EXUCUTER_FK                                           */
/*==============================================================*/
create  index EXUCUTER_FK on AUDIT (
EXECUTED_BY
);

/*==============================================================*/
/* Table: BRANDS                                                */
/*==============================================================*/
create table BRANDS (
   BRAND_ID             SERIAL               not null,
   BRAND_NAME           VARCHAR(25)          null,
   constraint PK_BRANDS primary key (BRAND_ID)
);

/*==============================================================*/
/* Index: BRANDS_PK                                             */
/*==============================================================*/
create unique index BRANDS_PK on BRANDS (
BRAND_ID
);

/*==============================================================*/
/* Table: CATEGORIES                                            */
/*==============================================================*/
create table CATEGORIES (
   CATEGORY_ID          SERIAL               not null,
   CATEGORY_NAME        VARCHAR(30)          null,
   constraint PK_CATEGORIES primary key (CATEGORY_ID)
);

/*==============================================================*/
/* Index: CATEGORIES_PK                                         */
/*==============================================================*/
create unique index CATEGORIES_PK on CATEGORIES (
CATEGORY_ID
);

/*==============================================================*/
/* Table: CUSTOMERS                                             */
/*==============================================================*/
create table CUSTOMERS (
   CUSTOMER_ID          SERIAL               not null,
   CUSTOMER_FIRST_NAME  VARCHAR(25)          null,
   CUSTOMER_LAST_NAME   VARCHAR(25)          null,
   CUSTOMER_PHONE       VARCHAR(10)          null,
   CUSTOMER_EMAIL       VARCHAR(100)         null,
   CUSTOMER_STREET      VARCHAR(50)          null,
   CUSTOMER_CITY        VARCHAR(25)          null,
   CUSTOMER_STATE       VARCHAR(25)          null,
   CUSTOMER_ZIP_CODE    VARCHAR(6)           null,
   constraint PK_CUSTOMERS primary key (CUSTOMER_ID)
);

/*==============================================================*/
/* Index: CUSTOMERS_PK                                          */
/*==============================================================*/
create unique index CUSTOMERS_PK on CUSTOMERS (
CUSTOMER_ID
);

/*==============================================================*/
/* Table: ORDERS                                                */
/*==============================================================*/
create table ORDERS (
   ORDER_ID             SERIAL               not null,
   CUSTOMER_ID          INT4                 null,
   STAFF_ID             INT4                 null,
   STORE_ID             INT4                 null,
   ORDER_STATUS         VARCHAR(10)          null,
   ORDER_DATE           DATE                 null,
   ORDER_REQUIRED_DATE  DATE                 null,
   ORDER_SHIPPED_DATE   DATE                 null,
   constraint PK_ORDERS primary key (ORDER_ID)
);

/*==============================================================*/
/* Index: ORDERS_PK                                             */
/*==============================================================*/
create unique index ORDERS_PK on ORDERS (
ORDER_ID
);

/*==============================================================*/
/* Index: STAFF_ORDERS_FK                                       */
/*==============================================================*/
create  index STAFF_ORDERS_FK on ORDERS (
CUSTOMER_ID
);

/*==============================================================*/
/* Index: COSTOMER_ORDERS_FK                                    */
/*==============================================================*/
create  index COSTOMER_ORDERS_FK on ORDERS (
STAFF_ID
);

/*==============================================================*/
/* Index: STORE_ORDERS_FK                                       */
/*==============================================================*/
create  index STORE_ORDERS_FK on ORDERS (
STORE_ID
);

/*==============================================================*/
/* Table: ORDER_ITEMS                                           */
/*==============================================================*/
create table ORDER_ITEMS (
   ORDER_ITEM_ID        SERIAL               not null,
   ORDER_ID             INT4                 not null,
   PRODUCT_ID           INT4                 not null,
   ORDER_ITEM_QUALITY   INT4                 null,
   ORDER_ITEM_LIST_PRICE DECIMAL(11,2)        null,
   ORDER_ITEM_DISCOUNT  DECIMAL(5,2)         null,
   constraint PK_ORDER_ITEMS primary key (ORDER_ITEM_ID)
);

/*==============================================================*/
/* Index: ORDER_ITEMS_PK                                        */
/*==============================================================*/
create unique index ORDER_ITEMS_PK on ORDER_ITEMS (
ORDER_ITEM_ID
);

/*==============================================================*/
/* Index: ORDERS_PRODUCTS_FK                                    */
/*==============================================================*/
create  index ORDERS_PRODUCTS_FK on ORDER_ITEMS (
ORDER_ID
);

/*==============================================================*/
/* Index: PRODUCTS_ORDERS_FK                                    */
/*==============================================================*/
create  index PRODUCTS_ORDERS_FK on ORDER_ITEMS (
PRODUCT_ID
);

/*==============================================================*/
/* Table: PRODUCTS                                              */
/*==============================================================*/
create table PRODUCTS (
   PRODUCT_ID           SERIAL               not null,
   CATEGORY_ID          INT4                 null,
   BRAND_ID             INT4                 null,
   PRODUCT_NAME         VARCHAR(30)          null,
   PRODUCT_MODEL_YEAR   VARCHAR(4)           null,
   PRODUCT_LIST_PRICE   DECIMAL(11,2)        null,
   constraint PK_PRODUCTS primary key (PRODUCT_ID)
);

/*==============================================================*/
/* Index: PRODUCTS_PK                                           */
/*==============================================================*/
create unique index PRODUCTS_PK on PRODUCTS (
PRODUCT_ID
);

/*==============================================================*/
/* Index: BRAND_PRODUCTS_FK                                     */
/*==============================================================*/
create  index BRAND_PRODUCTS_FK on PRODUCTS (
BRAND_ID
);

/*==============================================================*/
/* Index: CATEGORY_PRODUCTS_FK                                  */
/*==============================================================*/
create  index CATEGORY_PRODUCTS_FK on PRODUCTS (
CATEGORY_ID
);

/*==============================================================*/
/* Table: STAFFS                                                */
/*==============================================================*/
create table STAFFS (
   STAFF_ID             SERIAL               not null,
   STORE_ID             INT4                 null,
   MANAGER_ID           INT4                 null,
   STAFF_FIRST_NAME     VARCHAR(25)          null,
   STAFF_LAST_NAME      VARCHAR(25)          null,
   STAFF_EMAIL          VARCHAR(100)         null,
   STAFF_PHONE          VARCHAR(10)          null,
   STAFF_ACTIVE         BOOL                 null,
   constraint PK_STAFFS primary key (STAFF_ID)
);

/*==============================================================*/
/* Index: STAFFS_PK                                             */
/*==============================================================*/
create unique index STAFFS_PK on STAFFS (
STAFF_ID
);

/*==============================================================*/
/* Index: MANAGER_FK                                            */
/*==============================================================*/
create  index MANAGER_FK on STAFFS (
MANAGER_ID
);

/*==============================================================*/
/* Index: RELATIONSHIP_13_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_13_FK on STAFFS (
STORE_ID
);

/*==============================================================*/
/* Table: STOCKS                                                */
/*==============================================================*/
create table STOCKS (
   PRODUCT_ID           INT4                 not null,
   STORE_ID             INT4                 not null,
   STOCK_QUALITY        INT4                 null,
   constraint PK_STOCKS primary key (PRODUCT_ID, STORE_ID)
);

/*==============================================================*/
/* Index: STOCKS_PK                                             */
/*==============================================================*/
create unique index STOCKS_PK on STOCKS (
PRODUCT_ID,
STORE_ID
);

/*==============================================================*/
/* Index: PRODUCTS_STOCK_FK                                     */
/*==============================================================*/
create  index PRODUCTS_STOCK_FK on STOCKS (
PRODUCT_ID
);

/*==============================================================*/
/* Index: STOCKS_ORDERS_FK                                      */
/*==============================================================*/
create  index STOCKS_ORDERS_FK on STOCKS (
STORE_ID
);

/*==============================================================*/
/* Table: STORES                                                */
/*==============================================================*/
create table STORES (
   STORE_ID             SERIAL               not null,
   STORE_NAME           VARCHAR(50)          null,
   STORE_PHONE          VARCHAR(10)          null,
   STORE_EMAIL          VARCHAR(100)         null,
   STORE_STREET         VARCHAR(50)          null,
   STORE_CITY           VARCHAR(25)          null,
   STORE_STATE          VARCHAR(25)          null,
   STORE_ZIP_CODE       VARCHAR(6)           null,
   constraint PK_STORES primary key (STORE_ID)
);

/*==============================================================*/
/* Index: STORES_PK                                             */
/*==============================================================*/
create unique index STORES_PK on STORES (
STORE_ID
);

/*==============================================================*/
/* Table: USERS                                                 */
/*==============================================================*/
create table USERS (
   USER_ID              SERIAL               not null,
   NAME                 VARCHAR(50)          null,
   LASTNAME             VARCHAR(50)          null,
   USERNAME             VARCHAR(50)          null,
   EMAIL                VARCHAR(50)          null,
   PASSWORD             VARCHAR(255)         null,
   constraint PK_USERS primary key (USER_ID)
);

/*==============================================================*/
/* Index: USERS_PK                                              */
/*==============================================================*/
create unique index USERS_PK on USERS (
USER_ID
);

/*==============================================================*/
/* Table: VIP_CUSTOMERS                                         */
/*==============================================================*/
create table VIP_CUSTOMERS (
   VIP_ID               SERIAL               not null,
   CUSTOMER_ID          INT4                 null,
   constraint PK_VIP_CUSTOMERS primary key (VIP_ID)
);

/*==============================================================*/
/* Index: VIP_CUSTOMERS_PK                                      */
/*==============================================================*/
create unique index VIP_CUSTOMERS_PK on VIP_CUSTOMERS (
VIP_ID
);

/*==============================================================*/
/* Index: CUSTOMERVIP_FK                                        */
/*==============================================================*/
create  index CUSTOMERVIP_FK on VIP_CUSTOMERS (
CUSTOMER_ID
);

alter table AUDIT
   add constraint FK_AUDIT_EXUCUTER_USERS foreign key (EXECUTED_BY)
      references USERS (USER_ID)
      on delete cascade on update cascade;

alter table ORDERS
   add constraint FK_ORDERS_COSTOMER__CUSTOMER foreign key (STAFF_ID)
      references CUSTOMERS (CUSTOMER_ID)
      on delete cascade on update cascade;

alter table ORDERS
   add constraint FK_ORDERS_STAFF_ORD_STAFFS foreign key (CUSTOMER_ID)
      references STAFFS (STAFF_ID)
      on delete cascade on update cascade;

alter table ORDERS
   add constraint FK_ORDERS_STORE_ORD_STORES foreign key (STORE_ID)
      references STORES (STORE_ID)
      on delete cascade on update cascade;

alter table ORDER_ITEMS
   add constraint FK_ORDER_IT_ORDERS_PR_ORDERS foreign key (ORDER_ID)
      references ORDERS (ORDER_ID)
      on delete cascade on update cascade;

alter table ORDER_ITEMS
   add constraint FK_ORDER_IT_PRODUCTS__PRODUCTS foreign key (PRODUCT_ID)
      references PRODUCTS (PRODUCT_ID)
      on delete cascade on update cascade;

alter table PRODUCTS
   add constraint FK_PRODUCTS_BRAND_PRO_BRANDS foreign key (BRAND_ID)
      references BRANDS (BRAND_ID)
      on delete cascade on update cascade;

alter table PRODUCTS
   add constraint FK_PRODUCTS_CATEGORY__CATEGORI foreign key (CATEGORY_ID)
      references CATEGORIES (CATEGORY_ID)
      on delete cascade on update cascade;

alter table STAFFS
   add constraint FK_STAFFS_MANAGER_STAFFS foreign key (MANAGER_ID)
      references STAFFS (STAFF_ID)
      on delete cascade on update cascade;

alter table STAFFS
   add constraint FK_STAFFS_RELATIONS_STORES foreign key (STORE_ID)
      references STORES (STORE_ID)
      on delete cascade on update cascade;

alter table STOCKS
   add constraint FK_STOCKS_PRODUCTS__PRODUCTS foreign key (PRODUCT_ID)
      references PRODUCTS (PRODUCT_ID)
      on delete cascade on update cascade;

alter table STOCKS
   add constraint FK_STOCKS_STOCKS_OR_STORES foreign key (STORE_ID)
      references STORES (STORE_ID)
      on delete cascade on update cascade;

alter table VIP_CUSTOMERS
   add constraint FK_VIP_CUST_CUSTOMERV_CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMERS (CUSTOMER_ID)
      on delete cascade on update cascade;

