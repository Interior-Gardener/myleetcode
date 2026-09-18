-- 177. Nth Highest Salary
-- Medium
-- Topics
-- premium lock icon
-- Companies
-- SQL Schema
-- Pandas Schema
-- Table: Employee

-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | id          | int  |
-- | salary      | int  |
-- +-------------+------+
-- id is the primary key (column with unique values) for this table.
-- Each row of this table contains information about the salary of an employee.
 

-- Write a solution to find the nth highest distinct salary from the Employee table. If there are less than n distinct salaries, return null.

-- The result format is in the following example.

 

-- Example 1:

-- Input: 
-- Employee table:
-- +----+--------+
-- | id | salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- n = 2
-- Output: 
-- +------------------------+
-- | getNthHighestSalary(2) |
-- +------------------------+
-- | 200                    |
-- +------------------------+
-- Example 2:

-- Input: 
-- Employee table:
-- +----+--------+
-- | id | salary |
-- +----+--------+
-- | 1  | 100    |
-- +----+--------+
-- n = 2
-- Output: 
-- +------------------------+
-- | getNthHighestSalary(2) |
-- +------------------------+
-- | null                   |
-- +------------------------+

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
        -- Select MAX(salary)
        -- from Employee
        -- where salary in (
        --     select Distinct salary from
        --     Employee
        --     order by salary desc
        --     limit n
        -- )

        -- Select distinct(salary) from Employee where id = n

        -- Select  max(distinct(salary)) from Employee
        -- group by id
        -- having (count(distinct(salary))) = n
        -- -- having 
        -- order by salary desc

        -- select distinct(salary) from Employee
        -- having  count(distinct(salary))= n
        -- order by salary desc

        -- select salary from Employee a 
        -- join
        -- Employee b
        -- ON 
        -- a.id = b.id
        -- group by a.salary

        -- Self join after watching yt video and learning the question
        select a.salary
        from Employee a
        left join Employee b
            On b.salary > a.salary
        group by a.salary
        having count(distinct(b.salary)) = N - 1

        -- select distinct salary
        -- from Employee
        -- order by salary desc
        -- limit 1 offset n - 1;

  );
END