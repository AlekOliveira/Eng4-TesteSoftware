--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.21
-- Dumped by pg_dump version 9.5.21

-- Started on 2020-04-08 17:13:29

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2131 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 181 (class 1259 OID 16447)
-- Name: acerto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.acerto (
    "AceCod" integer NOT NULL,
    data date,
    valor numeric(8,2),
    tipo boolean,
    motivo character varying(200)
);


ALTER TABLE public.acerto OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 16453)
-- Name: Acerto_AceCod_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Acerto_AceCod_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Acerto_AceCod_seq" OWNER TO postgres;

--
-- TOC entry 2132 (class 0 OID 0)
-- Dependencies: 182
-- Name: Acerto_AceCod_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Acerto_AceCod_seq" OWNED BY public.acerto."AceCod";


--
-- TOC entry 183 (class 1259 OID 16455)
-- Name: caixa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.caixa (
    "CodCaixa" integer NOT NULL,
    "SaldoI" numeric(8,2),
    "SaldoF" numeric(8,2),
    "Status" boolean
);


ALTER TABLE public.caixa OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 16458)
-- Name: Caixa_CodCaixa_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Caixa_CodCaixa_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Caixa_CodCaixa_seq" OWNER TO postgres;

--
-- TOC entry 2133 (class 0 OID 0)
-- Dependencies: 184
-- Name: Caixa_CodCaixa_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Caixa_CodCaixa_seq" OWNED BY public.caixa."CodCaixa";


--
-- TOC entry 185 (class 1259 OID 16460)
-- Name: movcaixa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movcaixa (
    "CodCaixa" integer NOT NULL,
    valor numeric(8,2),
    "CodMov" integer NOT NULL,
    "AceCod" integer,
    tipo boolean
);


ALTER TABLE public.movcaixa OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 16463)
-- Name: MovCaixa_CodMov_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."MovCaixa_CodMov_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."MovCaixa_CodMov_seq" OWNER TO postgres;

--
-- TOC entry 2134 (class 0 OID 0)
-- Dependencies: 186
-- Name: MovCaixa_CodMov_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."MovCaixa_CodMov_seq" OWNED BY public.movcaixa."CodMov";


--
-- TOC entry 1994 (class 2604 OID 16465)
-- Name: AceCod; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.acerto ALTER COLUMN "AceCod" SET DEFAULT nextval('public."Acerto_AceCod_seq"'::regclass);


--
-- TOC entry 1995 (class 2604 OID 16466)
-- Name: CodCaixa; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caixa ALTER COLUMN "CodCaixa" SET DEFAULT nextval('public."Caixa_CodCaixa_seq"'::regclass);


--
-- TOC entry 1996 (class 2604 OID 16467)
-- Name: CodMov; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movcaixa ALTER COLUMN "CodMov" SET DEFAULT nextval('public."MovCaixa_CodMov_seq"'::regclass);


--
-- TOC entry 2135 (class 0 OID 0)
-- Dependencies: 182
-- Name: Acerto_AceCod_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Acerto_AceCod_seq"', 1, true);


--
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 184
-- Name: Caixa_CodCaixa_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Caixa_CodCaixa_seq"', 1, false);


--
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 186
-- Name: MovCaixa_CodMov_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."MovCaixa_CodMov_seq"', 1, false);


--
-- TOC entry 2117 (class 0 OID 16447)
-- Dependencies: 181
-- Data for Name: acerto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.acerto ("AceCod", data, valor, tipo, motivo) FROM stdin;
1	2019-04-08	150.50	f	Fralda das Crianças
\.


--
-- TOC entry 2119 (class 0 OID 16455)
-- Dependencies: 183
-- Data for Name: caixa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.caixa ("CodCaixa", "SaldoI", "SaldoF", "Status") FROM stdin;
\.


--
-- TOC entry 2121 (class 0 OID 16460)
-- Dependencies: 185
-- Data for Name: movcaixa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movcaixa ("CodCaixa", valor, "CodMov", "AceCod", tipo) FROM stdin;
\.


--
-- TOC entry 1998 (class 2606 OID 16469)
-- Name: pkAcerto; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.acerto
    ADD CONSTRAINT "pkAcerto" PRIMARY KEY ("AceCod");


--
-- TOC entry 2000 (class 2606 OID 16471)
-- Name: pkCaixa; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caixa
    ADD CONSTRAINT "pkCaixa" PRIMARY KEY ("CodCaixa");


--
-- TOC entry 2002 (class 2606 OID 16473)
-- Name: pkMovCaixa; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movcaixa
    ADD CONSTRAINT "pkMovCaixa" PRIMARY KEY ("CodMov");


--
-- TOC entry 2130 (class 0 OID 0)
-- Dependencies: 7
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2020-04-08 17:13:29

--
-- PostgreSQL database dump complete
--

