/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     18/11/2017 16:26:39                          */
/*==============================================================*/



-- Type package declaration
create or replace package PDTypes  
as
    TYPE ref_cursor IS REF CURSOR;
end;

-- Integrity package declaration
create or replace package IntegrityPackage AS
 procedure InitNestLevel;
 function GetNestLevel return number;
 procedure NextNestLevel;
 procedure PreviousNestLevel;
 end IntegrityPackage;
/

-- Integrity package definition
create or replace package body IntegrityPackage AS
 NestLevel number;

-- Procedure to initialize the trigger nest level
 procedure InitNestLevel is
 begin
 NestLevel := 0;
 end;


-- Function to return the trigger nest level
 function GetNestLevel return number is
 begin
 if NestLevel is null then
     NestLevel := 0;
 end if;
 return(NestLevel);
 end;

-- Procedure to increase the trigger nest level
 procedure NextNestLevel is
 begin
 if NestLevel is null then
     NestLevel := 0;
 end if;
 NestLevel := NestLevel + 1;
 end;

-- Procedure to decrease the trigger nest level
 procedure PreviousNestLevel is
 begin
 NestLevel := NestLevel - 1;
 end;

 end IntegrityPackage;
/


drop trigger TIB_CABECERAEVALUACION
/

drop trigger TIB_DETALLEEVALUACION
/

drop trigger TIB_PARAMETROEVALUACION
/

alter table CABECERAEVALUACION
   drop constraint FK_CABECERA_CABCAN_CANDIDAT
/

alter table DETALLEEVALUACION
   drop constraint FK_DETALLEE_CABDETEVA_CABECERA
/

alter table DETALLEEVALUACION
   drop constraint FK_DETALLEE_DETPAR_PARAMETR
/

drop index CABCAN_FK
/

drop table CABECERAEVALUACION cascade constraints
/

drop table CANDIDATO cascade constraints
/

drop index DETPAR_FK
/

drop index RELCABDETEVA_FK
/

drop table DETALLEEVALUACION cascade constraints
/

drop table PARAMETROEVALUACION cascade constraints
/

drop sequence CABSEC
/

drop sequence DETSEC
/

drop sequence PARSEC
/

create sequence CABSEC
increment by 1
start with 1
nocycle
/

create sequence DETSEC
increment by 1
start with 1
nocycle
/

create sequence PARSEC
increment by 1
start with 1
nocycle
/

/*==============================================================*/
/* Table: CABECERAEVALUACION                                    */
/*==============================================================*/
create table CABECERAEVALUACION  (
   CAB_CODIGO           INTEGER                         not null,
   CAN_CEDULA           VARCHAR2(10),
   CAB_FECHA            TIMESTAMP,
   constraint PK_CABECERAEVALUACION primary key (CAB_CODIGO)
)
/

/*==============================================================*/
/* Index: CABCAN_FK                                             */
/*==============================================================*/
create index CABCAN_FK on CABECERAEVALUACION (
   CAN_CEDULA ASC
)
/

/*==============================================================*/
/* Table: CANDIDATO                                             */
/*==============================================================*/
create table CANDIDATO  (
   CAN_CEDULA           VARCHAR2(10)                      not null,
   CAN_NOMBRE           VARCHAR2(30),
   CAN_FECHA_NACIMIENTO TIMESTAMP,
   constraint PK_CANDIDATO primary key (CAN_CEDULA)
)
/

/*==============================================================*/
/* Table: DETALLEEVALUACION                                     */
/*==============================================================*/
create table DETALLEEVALUACION  (
   DET_CODIGO           INTEGER                         not null,
   CAB_CODIGO           INTEGER                         not null,
   PAR_CODIGO           INTEGER,
   DET_CALIFICACION     INTEGER,
   constraint PK_DETALLEEVALUACION primary key (DET_CODIGO)
)
/

/*==============================================================*/
/* Index: RELCABDETEVA_FK                                       */
/*==============================================================*/
create index RELCABDETEVA_FK on DETALLEEVALUACION (
   CAB_CODIGO ASC
)
/

/*==============================================================*/
/* Index: DETPAR_FK                                             */
/*==============================================================*/
create index DETPAR_FK on DETALLEEVALUACION (
   PAR_CODIGO ASC
)
/

/*==============================================================*/
/* Table: PARAMETROEVALUACION                                   */
/*==============================================================*/
create table PARAMETROEVALUACION  (
   PAR_CODIGO           INTEGER                         not null,
   PAR_NOMBRE           VARCHAR2(30),
   PAR_PUNTAJE_MAXIMO   INTEGER,
   constraint PK_PARAMETROEVALUACION primary key (PAR_CODIGO)
)
/

alter table CABECERAEVALUACION
   add constraint FK_CABECERA_CABCAN_CANDIDAT foreign key (CAN_CEDULA)
      references CANDIDATO (CAN_CEDULA)
/

alter table DETALLEEVALUACION
   add constraint FK_DETALLEE_CABDETEVA_CABECERA foreign key (CAB_CODIGO)
      references CABECERAEVALUACION (CAB_CODIGO)
/

alter table DETALLEEVALUACION
   add constraint FK_DETALLEE_DETPAR_PARAMETR foreign key (PAR_CODIGO)
      references PARAMETROEVALUACION (PAR_CODIGO)
/


create trigger TIB_CABECERAEVALUACION before insert
on CABECERAEVALUACION for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "CAB_CODIGO" uses sequence CABSEC
    select CABSEC.NEXTVAL INTO :new.CAB_CODIGO from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/


create trigger TIB_DETALLEEVALUACION before insert
on DETALLEEVALUACION for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "DET_CODIGO" uses sequence DETSEC
    select DETSEC.NEXTVAL INTO :new.DET_CODIGO from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/


create trigger TIB_PARAMETROEVALUACION before insert
on PARAMETROEVALUACION for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "PAR_CODIGO" uses sequence PARSEC
    select PARSEC.NEXTVAL INTO :new.PAR_CODIGO from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/

