-- ----------------------------
-- Table structure for DEMO
-- ----------------------------
DROP TABLE "SCJGVUE"."DEMO";
CREATE TABLE "SCJGVUE"."DEMO" (
"ID" VARCHAR2(64 BYTE) NOT NULL ,
"NAME" VARCHAR2(64 BYTE) NULL ,
"APPLY_TIME" DATE NULL ,
"COUNT" NUMBER(20) NULL ,
"CREATE_BY" VARCHAR2(255 BYTE) NULL ,
"CREATE_TIME" DATE NULL ,
"UPDATE_BY" VARCHAR2(255 BYTE) NULL ,
"UPDATE_TIME" DATE NULL
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SCJGVUE"."DEMO" IS 'Demo';
COMMENT ON COLUMN "SCJGVUE"."DEMO"."ID" IS 'id';
COMMENT ON COLUMN "SCJGVUE"."DEMO"."NAME" IS '名称';
COMMENT ON COLUMN "SCJGVUE"."DEMO"."APPLY_TIME" IS '时间';
COMMENT ON COLUMN "SCJGVUE"."DEMO"."COUNT" IS '数量';
COMMENT ON COLUMN "SCJGVUE"."DEMO"."CREATE_BY" IS '创建人';
COMMENT ON COLUMN "SCJGVUE"."DEMO"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "SCJGVUE"."DEMO"."UPDATE_BY" IS '更新人';
COMMENT ON COLUMN "SCJGVUE"."DEMO"."UPDATE_TIME" IS '更新时间';

-- ----------------------------
-- Indexes structure for table DEMO
-- ----------------------------

-- ----------------------------
-- Checks structure for table DEMO
-- ----------------------------
ALTER TABLE "SCJGVUE"."DEMO" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table DEMO
-- ----------------------------
ALTER TABLE "SCJGVUE"."DEMO" ADD PRIMARY KEY ("ID");