# JetsProject

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/F-22_Raptor_edit1_%28cropped%29.jpg/600px-F-22_Raptor_edit1_%28cropped%29.jpg"  alt="Header Image" width="500" height="450"/>

# Description

The Jets project involves creating a fleet of jets with diverse capabilities. It offers a menu of options to explore various characteristics and perform actions on the fleet, including identifying the fastest jet, determining the jet with the longest range, flying all the jets, and managing the addition or removal of jets.

# Usage

1. **Clone the Repository:**
    ```bash
    git clone https://github.com/danielriggi/JetsProject.git
    cd JetsProject/src
    ```

2. **Compile and Run:**
    ```
    javac -d bin src/com/skilldistillery/jets/*.java
    java -classpath bin com.skilldistillery.jets.JetsApplication
    ```
    Follow the on-screen instructions to explore characteristics and peform actions on the fleet. 

# Tech Used
- **Programming Languages:**
    - Java 8 (version 1.8.0_391)
- **IDEs:**
    - Eclipse 2023-09 (https://www.eclipse.org/)
    - Visual Studio Code 1.84.2 (https://code.visualstudio.com/)
- **Version Control:**
    - Git 2.32.1 (https://git-scm.com/)

# Lessons Learned

**Abstraction and Modularity**

Throughout the development of this project, we gained valuable insights into the power and importance of abstraction. By employing abstraction techniques, we were able to create a modular and extensible codebase. Abstract classes served as blueprints for shared functionalities, providing a foundation for specific implementations in subclasses. This approach enhanced code readability, maintainability, and allowed for easy extension of the project.

**Class Extension and Interface Implementation**

The project extensively utilized class extension and interface implementation to model different types of jets. Subclasses extended the abstract Jet class, inheriting common attributes and behaviors while enabling specialization. Interfaces, such as CargoCarrier and CombatReady, provided a consistent structure for classes with specific functionalities.


