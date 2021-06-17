INSERT INTO USR (id, username, password) VALUES
  (1, 'root', '$2a$08$CYMfLZeNcOAAKWADKFAFCeZUgzgp4i6odqaHnQIGcThsgmnJM83xy'),
  (2, 'biba', '$2a$08$CYMfLZeNcOAAKWADKFAFCeZUgzgp4i6odqaHnQIGcThsgmnJM83xy'),
  (3, 'boba', '$2a$08$CYMfLZeNcOAAKWADKFAFCeZUgzgp4i6odqaHnQIGcThsgmnJM83xy');

INSERT INTO USER_ROLE (user_id, roles) VALUES
    (1, 'ADMIN'),
    (2, 'LISTENER'),
    (3, 'LISTENER');

