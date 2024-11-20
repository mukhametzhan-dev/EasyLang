import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import CreateProject from './CreateProject';

function Home() {
  const handleCreateProject = (e) => {
    e.preventDefault();
    const projectData = {
        name: projectName,
        description: projectDescription,
        deadline: projectDeadline, // format: YYYY-MM-DD
    };
    
    axios.post('http://localhost:8080/api/projects/create', projectData)
        .then(response => {
            alert('Project created successfully!');
            setProjectId(response.data.id); // Assuming the response contains the project ID
        })
        .catch(error => {
            alert('Project creation failed: ' + error.response.data);
        });
};
  const navigate = useNavigate();
  const username = localStorage.getItem('username');
  const role = localStorage.getItem('role');
  useEffect(() => {
    if(username === null) {
      navigate('/login');
    }
  }, [username, navigate]);
  console.log('username', username);
  if(username === null) {
    navigate('/login');

  }


  const handleLogout = () => {
    localStorage.removeItem('username');
    navigate('/');
  };

  return (
    <div>
      <h1>Hello {username}</h1>
      <p>Welcome to the Home page</p>
      <p>Your role is {role}</p>
      <p>Only managers can see this</p>
      
      <button onClick={handleLogout}>Logout</button> 
      <CreateProject class="checker"/>

    </div>
  );
}

export default Home;