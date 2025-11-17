# Student Management System – Java (Exception Handling + Multithreading)

This project is created as part of **Java Lab Assignment 3**.  
It demonstrates a complete **Student Management System** featuring:

- Custom Exceptions  
- Multithreading  
- Wrapper Classes  
- Input Validation  
- Clean OOP Structure  

---

## 🚀 Features

### ✔ Exception Handling
- Validates all user inputs  
- Custom exception: `StudentNotFoundException`  
- Handles invalid marks, empty fields, wrong formats, etc.

### ✔ Multithreading
- Simulates a loading animation when saving student data  
- Implemented using `Thread` and `Runnable` (`Loader` class)

### ✔ Wrapper Classes & Autoboxing
- Uses `Integer` and `Double` for roll numbers and marks  
- Converts user input using autoboxing  

---

## 📁 Project Structure

```
/src
 ├── RecordActions.java
 ├── Student.java
 ├── StudentManager.java
 ├── StudentNotFoundException.java
 └── Loader.java
```

---

## ▶ How to Run

1. Clone the repository:
```bash
git clone https://github.com/yourusername/StudentManagementSystem.git
```

2. Compile all Java files:
```bash
javac *.java
```

3. Run the project:
```bash
java StudentManager
```

---

## 📝 Sample Output

```
Enter Roll No (Integer): 102
Enter Name: Karan
Enter Email: karan@mail.com
Enter Course: BCA
Enter Marks: 77.5
Loading.....
Student added successfully!

Roll No: 102
Name: Karan
Email: karan@mail.com
Course: BCA
Marks: 77.5
Grade: B

Program execution completed.
```

---

## 📚 Concepts Used

- try-catch-finally  
- User-defined exceptions  
- Runnable + Thread  
- Autoboxing (int → Integer, double → Double)  
- Validation & clean coding  

---

## 👨‍💻 Author

Created by **Pranjal Dutta** (as per submission requirements)

---

## 📜 License
This project is free to use for educational purposes.
