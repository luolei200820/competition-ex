-- public.tool_borrow definition

-- Drop table

-- DROP TABLE public.tool_borrow;

CREATE TABLE public.tool_borrow (
	id int4 DEFAULT nextval('toolborrow_id_seq'::regclass) NOT NULL,
	borrow_user_id int4 NULL,
	tool_id int4 NULL,
	start_time timestamp NULL,
	expect_time timestamp NULL,
	duration int4 NULL,
	approved_user_id int4 NULL,
	approved_state bool NULL,
	CONSTRAINT toolborrow_pk PRIMARY KEY (id)
);


-- public.tool_return definition

-- Drop table

-- DROP TABLE public.tool_return;

CREATE TABLE public.tool_return (
	id int4 DEFAULT nextval('toolborrow_id_seq'::regclass) NOT NULL,
	tool_borrow_id int4 NULL,
	"number" int4 NULL,
	approved_user_id int4 NULL,
	approved_state bool NULL,
	tool_state varchar NULL,
	damaged bool NULL,
	CONSTRAINT tool_return_pk PRIMARY KEY (id)
);


-- public."user" definition

-- Drop table

-- DROP TABLE public."user";

CREATE TABLE public."user" (
	id serial4 NOT NULL,
	username varchar NOT NULL,
	"password" varchar NOT NULL,
	"admin" bool NOT NULL,
	phone varchar NULL,
	department varchar NULL,
	CONSTRAINT user_pk PRIMARY KEY (id),
	CONSTRAINT user_unique UNIQUE (username)
);


-- public.tool_category definition

-- Drop table

-- DROP TABLE public.tool_category;

CREATE TABLE public.tool_category (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	description varchar NULL,
	note varchar NULL,
	create_time timestamp NOT NULL,
	create_user_id int4 NOT NULL,
	CONSTRAINT tool_category_pk PRIMARY KEY (id),
	CONSTRAINT tool_category_unique UNIQUE (name),
	CONSTRAINT tool_category_user_fk FOREIGN KEY (create_user_id) REFERENCES public."user"(id)
);


-- public.tool_vendor definition

-- Drop table

-- DROP TABLE public.tool_vendor;

CREATE TABLE public.tool_vendor (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	description varchar NOT NULL,
	address varchar NOT NULL,
	zip_code varchar NOT NULL,
	telephone varchar NOT NULL,
	contacts varchar NOT NULL,
	credit_state bool NOT NULL,
	create_time timestamp NOT NULL,
	create_user_id int4 NOT NULL,
	CONSTRAINT tool_vendor_pk PRIMARY KEY (id),
	CONSTRAINT tool_vendor_unique UNIQUE (name),
	CONSTRAINT tool_vendor_user_fk FOREIGN KEY (create_user_id) REFERENCES public."user"(id)
);


-- public.tool definition

-- Drop table

-- DROP TABLE public.tool;

CREATE TABLE public.tool (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	description varchar NULL,
	category_id int4 NOT NULL,
	vendor_id int4 NOT NULL,
	specs varchar NULL,
	"number" int4 NOT NULL,
	CONSTRAINT tool_pk PRIMARY KEY (id),
	CONSTRAINT tool_unique UNIQUE (name),
	CONSTRAINT tool_tool_category_fk FOREIGN KEY (category_id) REFERENCES public.tool_category(id),
	CONSTRAINT tool_tool_vendor_fk FOREIGN KEY (vendor_id) REFERENCES public.tool_vendor(id)
);