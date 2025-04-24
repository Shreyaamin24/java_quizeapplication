# java_quizeapplication
An interactive **Java-based Online Quiz System** where users can take quizzes, track progress, and view results. Admins can manage quizzes and questions through a structured backend. Built using **Java + MySQL + JDBC**.
 Features
 User Authentication
- Secure registration and login
- Passwords stored with hashing (SHA-256)
 Quiz Management (Admin)
- Add, update, or delete quizzes and questions
- Multiple-choice questions with correct answers
 Quiz Taking (User)
- Choose from available quizzes
- Real-time feedback: Correct / Incorrect
- Final score displayed at the end
 Score Tracking
- Record and view past attempts
- Track user progress over time
 Leaderboard *(Optional)*
- Display top scorers
- Rankings based on average or total scores
Technologies
- Java (JDK 17+)
  MySQL
  JDBC (mysql-connector-j-9.3.0.jar)
  compilation command:javac -cp "lib\mysql-connector-j-9.3.0.jar" -d bin src\Main.java src\dao\*.java src\model\*.java src\ui\*.java src\utils\*.java
  run command:java -cp "lib\mysql-connector-j-9.3.0.jar;bin" Main

