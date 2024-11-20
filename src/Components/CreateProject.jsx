import React, { useState } from 'react';
import axios from 'axios';
import './FormStyles.css';

function CreateProject() {
  const [projectName, setProjectName] = useState('');
  const [projectDescription, setProjectDescription] = useState('');
  const [projectDeadline, setProjectDeadline] = useState('');
  const [usernames, setUsernames] = useState('');
  const [projectId, setProjectId] = useState(null);
  
  const token = localStorage.getItem('token'); // Assuming the token is stored in localStorage
  console.log('token', token);
  const handleCreateProject = (e) => {
    e.preventDefault();
    const projectData = {
      name: projectName,
      description: projectDescription,
      deadline: projectDeadline,
    };
    
    axios.post('http://localhost:8080/api/projects/create', projectData, {
      headers: {
        'Authorization': `Bearer ${token}`
      }
    })
    .then(response => {
      alert('Project created successfully!');
      setProjectId(response.data.id);
    })
    .catch(error => {
      alert('Project creation failed: ' + error.response.data);
    });
  };

  const handleAddUsersToProject = (e) => {
    e.preventDefault();
    const users = usernames.split(',').map(name => name.trim());
    
    axios.post(`http://localhost:8080/api/projects/${projectId}/addUsers`, { usernames: users }, {
      headers: {
        'Authorization': `Bearer ${token}`
      }
    })
    .then(response => {
      alert('Users added to project successfully!');
      setUsernames('');
    })
    .catch(error => {
      alert('Adding users failed: ' + error.response.data);
    });
  };

  return (
    <div className="form-container">
      <h2>Create Project</h2>
      <form onSubmit={handleCreateProject}>
        <input
          type="text"
          name="projectName"
          placeholder="Project Name"
          value={projectName}
          onChange={(e) => setProjectName(e.target.value)}
          required
        />
        <textarea
          name="projectDescription"
          placeholder="Project Description"
          value={projectDescription}
          onChange={(e) => setProjectDescription(e.target.value)}
          required
        />
        <input
          type="date"
          name="projectDeadline"
          placeholder="Deadline"
          value={projectDeadline}
          onChange={(e) => setProjectDeadline(e.target.value)}
          required
        />
        <button type="submit">Create Project</button>
      </form>

      {projectId && (
        <form onSubmit={handleAddUsersToProject} className="add-users-form">
          <h3>Add Users to Project</h3>
          <input
            type="text"
            name="usernames"
            placeholder="Enter usernames separated by commas"
            value={usernames}
            onChange={(e) => setUsernames(e.target.value)}
            required
          />
          <button type="submit">Add Users</button>
        </form>
      )}
    </div>
  );
}

export default CreateProject;