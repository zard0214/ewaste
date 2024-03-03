INSERT INTO t_user (login_name, password, user_name, email, provider, image_url)
VALUES ('admin', '$2a$10$nmDeMn0Psn1BucCKrcAVOeEYmlF4biPG3YIYiaO9E.VeD8PeUJ3dK', 'admin', 'z15168385776@gmail.com', 'local', 'https://lh3.googleusercontent.com/a/ACg8ocKewdE15OA3FeMlVy6drH2cmxgusa6APb1Nlvk_tGWwLIM=s96-c');

INSERT INTO t_role (role_name, role_code, creator_id) VALUES ('ADMIN', 'ROLE_ADMIN', 1);
INSERT INTO t_role (role_name, role_code, creator_id) VALUES ('STAFF', 'ROLE_STAFF', 1);
INSERT INTO t_role (role_name, role_code, creator_id) VALUES ('USER', 'ROLE_USER', 1);

INSERT INTO t_user_role (user_id, role_id, creator_id) VALUES (1, 1, 1);
INSERT INTO t_user_role (user_id, role_id, creator_id) VALUES (1, 2, 1);
INSERT INTO t_user_role (user_id, role_id, creator_id) VALUES (1, 3, 1);

