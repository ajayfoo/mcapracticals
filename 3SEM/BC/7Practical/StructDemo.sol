// SPDX-License-Identifier: MIT

pragma solidity ^0.8.18;

contract StructDemo {
    // Structure of Student
    struct Student {
        int256 rollno;
        string name;
        string class;
        string department;
        string course;
    }

    Student[] public students;

    // Function to add Student details
    function addStudent(
        int256 rollno,
        string memory name,
        string memory class,
        string memory department,
        string memory course
    ) public {
        Student memory s = Student(rollno, name, class, department, course);
        students.push(s);
    }

    // Function to get details of Student
    function getStudent(int256 rollno)
        public
        view
        returns (
            string memory name,
            string memory class,
            string memory department,
            string memory course
        )
    {
        for (uint256 i = 0; i < students.length; i++) {
            Student memory s = students[i];
            if (s.rollno == rollno) {
                return (s.name, s.class, s.department, s.course);
            }
        }
        // If provided student rollno is not present
        // return empty strings         return ("", "", "", "");
    }
}

