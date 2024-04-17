import React, { useState } from 'react';
import axios from 'axios';

const PostForm = () => {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8080/api/${id}/posts', { title, content })
      .then(response => {
        console.log('Post created successfully:', response.data);
        setTitle(''); // Clear the input fields
        setContent('');
      })
      .catch(error => {
        console.error('Error creating post:', error);
      });
  };

  var id =0;

  return (
    <div>
      <h2>Create New Post</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Title:</label>
          <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
        </div>
        <div>
          <label>Content:</label>
          <textarea value={content} onChange={(e) => setContent(e.target.value)} />
        </div>
        <div>
          <label>Author id:</label>
          <textarea value={id} onChange={(e) => setContent(e.target.value)} />
        </div>
        <button type="submit">Create</button>
      </form>
    </div>
  );
};

export default PostForm;
