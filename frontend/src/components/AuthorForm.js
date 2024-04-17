import React, { useState } from 'react';
import axios from 'axios';

const AuthorForm = () => {
  const [name, setName] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8080/api/authors', { name })
      .then(response => {
        console.log('Author created successfully:', response.data);
        setName(''); // Clear the input field
      })
      .catch(error => {
        console.error('Error creating author:', error);
      });
  };

  return (
    <div>
      <h2>Create New Author</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name:</label>
          <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
        </div>
        <button type="submit">Create</button>
      </form>
    </div>
  );
};

export default AuthorForm;
