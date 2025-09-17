package com.Santho.API;
import jakarta.persistence.*;
@Entity
@Table(name = "students")
public class StudentEntity 
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;
	    private String email;
	    private String department;
	    
	    public StudentEntity() 
	    {
	        // default constructor required by JPA
	    }

	    public StudentEntity(String name, String email, String department)
	    {
	        this.name = name;
	        this.email = email;
	        this.department = department;
	    }

	    // Getters and Setters
	    public int getId() 
	    { return id; 
	    }
	    public void setId(int id) 
	    { this.id = id;
	    }

	    public String getName() 
	    { return name; 
	    }
	    public void setName(String name) 
	    { this.name = name;
	    }

	    public String getEmail() 
	    { return email;
	    }
	    public void setEmail(String email) 
	    { this.email = email; 
	    }

	    public String getDepartment() 
	    { return department; 
	    }
	    public void setDepartment(String department) 
	    { this.department = department; 
	    }
	}


