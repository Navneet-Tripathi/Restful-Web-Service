CREATE TABLE user_details(
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR(50) NOT NULL,
birth_date DATE NOT NULL);

CREATE TABLE user_posts(
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
post_heading NVARCHAR(1000) NOT NULL,
post_content LONGTEXT,
user_id BIGINT NOT NULL,

FOREIGN KEY (user_id) REFERENCES user_details(id) ON DELETE CASCADE);

INSERT INTO user_details(user_name, birth_date)
VALUES('Navneet Tripathi', '2001-01-01'), ('Nitesh Tripathi', '1998-07-06');


INSERT INTO user_posts(post_heading, post_content, user_id)
VALUES('Learn Spring-Boot', 'I want to learn spring-boot fundamentals', 1), 
('Learn SQL', 'I want to learn fundamentals of sql & be a proficient sql developer', 1),
('Learn Auto-CAD', 'I want to learn fundamentals of auto-cad', 2);
