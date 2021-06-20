INSERT INTO USR (username, password) VALUES
  ('root', '$2a$08$CYMfLZeNcOAAKWADKFAFCeZUgzgp4i6odqaHnQIGcThsgmnJM83xy'),
  ('biba', '$2a$08$CYMfLZeNcOAAKWADKFAFCeZUgzgp4i6odqaHnQIGcThsgmnJM83xy'),
  ('boba', '$2a$08$CYMfLZeNcOAAKWADKFAFCeZUgzgp4i6odqaHnQIGcThsgmnJM83xy');

INSERT INTO USER_ROLE (user_id, role) VALUES
    (1, 'ADMIN'),
    (2, 'SPEAKER'),
    (3, 'LISTENER');

INSERT INTO ROOM (id_room, number) VALUES
    (1, 1337),
    (2, 1234),
    (3, 15);

INSERT INTO TALK (id_talk, theme, short_info) VALUES
    (1, 'Programing', 'About programing'),
    (2, 'Not about programing', 'About databases'),
    (3, '!programing && programing', 'About something strange (*cough *cough... js)'),
    (4, '1213', '123');

INSERT INTO USER_TALKS (user_id, id_talk) VALUES
    (1, 1),
    (1, 2),
    (2, 1);

INSERT INTO SCHEDULE (id_schedule, id_room, id_talk, time_of_talk) VALUES
    (1, 1, 1, '2020-11-01 14:00:00'),
    (2, 2, 2, '2021-08-01 14:30:00'),
    (3, 3, 3, '2025-03-11 16:10:00'),
    (4, 3, 4, '2030-12-01 15:20:00');

