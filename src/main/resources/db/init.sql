CREATE SEQUENCE employees_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE employees (
    id integer PRIMARY KEY DEFAULT nextval('employees_id_seq'),
    name VARCHAR(50) NOT NULL CHECK (name ~ '^[a-zA-Z ]{1,10}$'),
    position VARCHAR(50) NOT NULL,
    phone VARCHAR(15) NOT NULL CHECK (phone ~ '^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$'),
    email VARCHAR(100) NOT NULL CHECK (email ~ '^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$')
);

INSERT INTO employees(name, position, phone, email) VALUES
('John Doe', 'Manager', '010-1234-5678', 'johndoe@example.com'),
('Jane Smith', 'Developer', '010-9876-5432', 'janesmith@example.com'),
('Alice', 'HR', '010-5555-1212', 'alice@example.com'),
('Bob White', 'QA Tester', '010-4444-2323', 'bobwhite@example.com'),
('Charlie', 'SysAdmin', '010-3333-4545', 'charlie@example.com'),
('David', 'Analyst', '010-2222-6767', 'david@example.com'),
('Eve Blue', 'Product Manager', '010-1111-8989', 'eveblue@example.com'),
('Frank Yel', 'Sales Exec', '010-9999-1010', 'frankyel@example.com'),
('Grace Red', 'Marketing', '010-8888-2121', 'gracered@example.com'),
('Henry', 'Tech Lead', '010-7777-3232', 'henry@example.com');

