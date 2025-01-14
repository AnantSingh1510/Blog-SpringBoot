import React from 'react';

const PostDetails = ({ posts }) => {
  return (
    <div>
      <h2>Posts</h2>
      {posts.map(post => (
        <div key={post.id}>
          <h3>{post.title}</h3>
          <p>{post.content}</p>
          <p>Author: {post.author}</p>
          <hr /> {/* Add a horizontal line between posts */}
        </div>
      ))}
    </div>
  );
};

export default PostDetails;
