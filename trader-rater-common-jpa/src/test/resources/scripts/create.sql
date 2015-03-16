--
-- PostgreSQL database dump
--

-- Started on 2014-06-11 12:54:47

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1528 (class 1259 OID 113206)
-- Dependencies: 3
-- Name: bid; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bid (
    bid_id bigint NOT NULL,
    created timestamp without time zone,
    value numeric(38,0),
    provider_id bigint,
    bid_state_id bigint,
    task_id bigint
);


ALTER TABLE public.bid OWNER TO postgres;

--
-- TOC entry 1529 (class 1259 OID 113211)
-- Dependencies: 3
-- Name: bid_state; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bid_state (
    bid_state_id bigint NOT NULL,
    state character varying(255)
);


ALTER TABLE public.bid_state OWNER TO postgres;

--
-- TOC entry 1530 (class 1259 OID 113216)
-- Dependencies: 3
-- Name: client; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE client (
    client_id bigint NOT NULL,
    user_details_id bigint
);


ALTER TABLE public.client OWNER TO postgres;

--
-- TOC entry 1531 (class 1259 OID 113221)
-- Dependencies: 3
-- Name: provider; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE provider (
    provider_id bigint NOT NULL,
    title character varying(255),
    user_details_id bigint
);


ALTER TABLE public.provider OWNER TO postgres;

--
-- TOC entry 1532 (class 1259 OID 113226)
-- Dependencies: 3
-- Name: rating; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE rating (
    rating_id bigint NOT NULL,
    long_description character varying(255),
    score integer,
    short_description character varying(255),
    client_id bigint,
    task_id bigint
);


ALTER TABLE public.rating OWNER TO postgres;

--
-- TOC entry 1533 (class 1259 OID 113234)
-- Dependencies: 3
-- Name: role; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE role (
    role_id bigint NOT NULL,
    role_type character varying(255),
    title character varying(255)
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 1527 (class 1259 OID 112851)
-- Dependencies: 3
-- Name: sequence; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sequence (
    seq_name character varying(50) NOT NULL,
    seq_count numeric(38,0)
);


ALTER TABLE public.sequence OWNER TO postgres;

--
-- TOC entry 1534 (class 1259 OID 113242)
-- Dependencies: 3
-- Name: service; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE service (
    service_id bigint NOT NULL,
    description character varying(255),
    provider_id bigint,
    service_type_id bigint
);


ALTER TABLE public.service OWNER TO postgres;

--
-- TOC entry 1536 (class 1259 OID 113255)
-- Dependencies: 3
-- Name: service_task_job_type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE service_task_job_type (
    service_task_job_type_id bigint NOT NULL,
    description character varying(255),
    title character varying(255),
    service_task_type_id bigint
);


ALTER TABLE public.service_task_job_type OWNER TO postgres;

--
-- TOC entry 1535 (class 1259 OID 113247)
-- Dependencies: 3
-- Name: service_task_type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE service_task_type (
    service_task_type_id bigint NOT NULL,
    description character varying(255),
    title character varying(255),
    service_type_id bigint
);


ALTER TABLE public.service_task_type OWNER TO postgres;

--
-- TOC entry 1537 (class 1259 OID 113263)
-- Dependencies: 3
-- Name: service_type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE service_type (
    service_type_id bigint NOT NULL,
    description character varying(255),
    title character varying(255)
);


ALTER TABLE public.service_type OWNER TO postgres;

--
-- TOC entry 1538 (class 1259 OID 113271)
-- Dependencies: 3
-- Name: task; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE task (
    task_id bigint NOT NULL,
    created timestamp without time zone,
    post_code character varying(255),
    client_id bigint,
    service_task_job_type_id bigint,
    service_task_type_id bigint,
    service_type_id bigint,
    task_state_id bigint
);


ALTER TABLE public.task OWNER TO postgres;

--
-- TOC entry 1539 (class 1259 OID 113276)
-- Dependencies: 3
-- Name: task_state; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE task_state (
    task_state_id bigint NOT NULL,
    description character varying(255),
    state character varying(255),
    title character varying(255)
);


ALTER TABLE public.task_state OWNER TO postgres;

--
-- TOC entry 1540 (class 1259 OID 113284)
-- Dependencies: 3
-- Name: task_type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE task_type (
    task_type_id bigint NOT NULL,
    description character varying(255),
    title character varying(255)
);


ALTER TABLE public.task_type OWNER TO postgres;

--
-- TOC entry 1541 (class 1259 OID 113292)
-- Dependencies: 3
-- Name: user_details; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE user_details (
    user_details_id bigint NOT NULL,
    address character varying(255),
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    mobile_phone character varying(255),
    password character varying(255),
    phone character varying(255),
    post_code character varying(255),
    user_name character varying(255) NOT NULL,
    role_id bigint
);


ALTER TABLE public.user_details OWNER TO postgres;

--
-- TOC entry 1822 (class 2606 OID 113210)
-- Dependencies: 1528 1528
-- Name: bid_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bid
    ADD CONSTRAINT bid_pkey PRIMARY KEY (bid_id);


--
-- TOC entry 1824 (class 2606 OID 113215)
-- Dependencies: 1529 1529
-- Name: bid_state_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bid_state
    ADD CONSTRAINT bid_state_pkey PRIMARY KEY (bid_state_id);


--
-- TOC entry 1826 (class 2606 OID 113220)
-- Dependencies: 1530 1530
-- Name: client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_pkey PRIMARY KEY (client_id);


--
-- TOC entry 1828 (class 2606 OID 113225)
-- Dependencies: 1531 1531
-- Name: provider_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY provider
    ADD CONSTRAINT provider_pkey PRIMARY KEY (provider_id);


--
-- TOC entry 1830 (class 2606 OID 113233)
-- Dependencies: 1532 1532
-- Name: rating_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY rating
    ADD CONSTRAINT rating_pkey PRIMARY KEY (rating_id);


--
-- TOC entry 1832 (class 2606 OID 113241)
-- Dependencies: 1533 1533
-- Name: role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_pkey PRIMARY KEY (role_id);


--
-- TOC entry 1820 (class 2606 OID 112855)
-- Dependencies: 1527 1527
-- Name: sequence_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sequence
    ADD CONSTRAINT sequence_pkey PRIMARY KEY (seq_name);


--
-- TOC entry 1834 (class 2606 OID 113246)
-- Dependencies: 1534 1534
-- Name: service_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY service
    ADD CONSTRAINT service_pkey PRIMARY KEY (service_id);


--
-- TOC entry 1838 (class 2606 OID 113262)
-- Dependencies: 1536 1536
-- Name: service_task_job_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY service_task_job_type
    ADD CONSTRAINT service_task_job_type_pkey PRIMARY KEY (service_task_job_type_id);


--
-- TOC entry 1836 (class 2606 OID 113254)
-- Dependencies: 1535 1535
-- Name: service_task_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY service_task_type
    ADD CONSTRAINT service_task_type_pkey PRIMARY KEY (service_task_type_id);


--
-- TOC entry 1840 (class 2606 OID 113270)
-- Dependencies: 1537 1537
-- Name: service_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY service_type
    ADD CONSTRAINT service_type_pkey PRIMARY KEY (service_type_id);


--
-- TOC entry 1842 (class 2606 OID 113275)
-- Dependencies: 1538 1538
-- Name: task_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY task
    ADD CONSTRAINT task_pkey PRIMARY KEY (task_id);


--
-- TOC entry 1844 (class 2606 OID 113283)
-- Dependencies: 1539 1539
-- Name: task_state_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY task_state
    ADD CONSTRAINT task_state_pkey PRIMARY KEY (task_state_id);


--
-- TOC entry 1846 (class 2606 OID 113291)
-- Dependencies: 1540 1540
-- Name: task_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY task_type
    ADD CONSTRAINT task_type_pkey PRIMARY KEY (task_type_id);


--
-- TOC entry 1848 (class 2606 OID 113299)
-- Dependencies: 1541 1541
-- Name: user_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY user_details
    ADD CONSTRAINT user_details_pkey PRIMARY KEY (user_details_id);


--
-- TOC entry 1851 (class 2606 OID 113310)
-- Dependencies: 1528 1823 1529
-- Name: fk_bid_bid_state_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bid
    ADD CONSTRAINT fk_bid_bid_state_id FOREIGN KEY (bid_state_id) REFERENCES bid_state(bid_state_id);


--
-- TOC entry 1850 (class 2606 OID 113305)
-- Dependencies: 1827 1531 1528
-- Name: fk_bid_provider_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bid
    ADD CONSTRAINT fk_bid_provider_id FOREIGN KEY (provider_id) REFERENCES provider(provider_id);


--
-- TOC entry 1849 (class 2606 OID 113300)
-- Dependencies: 1538 1528 1841
-- Name: fk_bid_task_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bid
    ADD CONSTRAINT fk_bid_task_id FOREIGN KEY (task_id) REFERENCES task(task_id);


--
-- TOC entry 1852 (class 2606 OID 113315)
-- Dependencies: 1847 1530 1541
-- Name: fk_client_user_details_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client
    ADD CONSTRAINT fk_client_user_details_id FOREIGN KEY (user_details_id) REFERENCES user_details(user_details_id);


--
-- TOC entry 1853 (class 2606 OID 113320)
-- Dependencies: 1847 1541 1531
-- Name: fk_provider_user_details_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY provider
    ADD CONSTRAINT fk_provider_user_details_id FOREIGN KEY (user_details_id) REFERENCES user_details(user_details_id);


--
-- TOC entry 1854 (class 2606 OID 113325)
-- Dependencies: 1825 1530 1532
-- Name: fk_rating_client_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rating
    ADD CONSTRAINT fk_rating_client_id FOREIGN KEY (client_id) REFERENCES client(client_id);


--
-- TOC entry 1855 (class 2606 OID 113330)
-- Dependencies: 1538 1841 1532
-- Name: fk_rating_task_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rating
    ADD CONSTRAINT fk_rating_task_id FOREIGN KEY (task_id) REFERENCES task(task_id);


--
-- TOC entry 1857 (class 2606 OID 113340)
-- Dependencies: 1531 1827 1534
-- Name: fk_service_provider_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY service
    ADD CONSTRAINT fk_service_provider_id FOREIGN KEY (provider_id) REFERENCES provider(provider_id);


--
-- TOC entry 1856 (class 2606 OID 113335)
-- Dependencies: 1534 1537 1839
-- Name: fk_service_service_type_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY service
    ADD CONSTRAINT fk_service_service_type_id FOREIGN KEY (service_type_id) REFERENCES service_type(service_type_id);


--
-- TOC entry 1859 (class 2606 OID 113350)
-- Dependencies: 1536 1835 1535
-- Name: fk_service_task_job_type_service_task_type_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY service_task_job_type
    ADD CONSTRAINT fk_service_task_job_type_service_task_type_id FOREIGN KEY (service_task_type_id) REFERENCES service_task_type(service_task_type_id);


--
-- TOC entry 1858 (class 2606 OID 113345)
-- Dependencies: 1535 1839 1537
-- Name: fk_service_task_type_service_type_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY service_task_type
    ADD CONSTRAINT fk_service_task_type_service_type_id FOREIGN KEY (service_type_id) REFERENCES service_type(service_type_id);


--
-- TOC entry 1862 (class 2606 OID 113365)
-- Dependencies: 1538 1530 1825
-- Name: fk_task_client_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task
    ADD CONSTRAINT fk_task_client_id FOREIGN KEY (client_id) REFERENCES client(client_id);


--
-- TOC entry 1861 (class 2606 OID 113360)
-- Dependencies: 1538 1837 1536
-- Name: fk_task_service_task_job_type_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task
    ADD CONSTRAINT fk_task_service_task_job_type_id FOREIGN KEY (service_task_job_type_id) REFERENCES service_task_job_type(service_task_job_type_id);


--
-- TOC entry 1863 (class 2606 OID 113370)
-- Dependencies: 1538 1535 1835
-- Name: fk_task_service_task_type_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task
    ADD CONSTRAINT fk_task_service_task_type_id FOREIGN KEY (service_task_type_id) REFERENCES service_task_type(service_task_type_id);


--
-- TOC entry 1860 (class 2606 OID 113355)
-- Dependencies: 1538 1839 1537
-- Name: fk_task_service_type_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task
    ADD CONSTRAINT fk_task_service_type_id FOREIGN KEY (service_type_id) REFERENCES service_type(service_type_id);


--
-- TOC entry 1864 (class 2606 OID 113375)
-- Dependencies: 1539 1843 1538
-- Name: fk_task_task_state_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task
    ADD CONSTRAINT fk_task_task_state_id FOREIGN KEY (task_state_id) REFERENCES task_state(task_state_id);


--
-- TOC entry 1865 (class 2606 OID 113380)
-- Dependencies: 1831 1533 1541
-- Name: fk_user_details_role_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_details
    ADD CONSTRAINT fk_user_details_role_id FOREIGN KEY (role_id) REFERENCES role(role_id);


--
-- TOC entry 1869 (class 0 OID 0)
-- Dependencies: 3
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-06-11 12:54:47

--
-- PostgreSQL database dump complete
--

