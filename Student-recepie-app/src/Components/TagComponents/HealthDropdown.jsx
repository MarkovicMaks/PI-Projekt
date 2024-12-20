import Form from 'react-bootstrap/Form';

function HealthDropdown() {
  return (
    <Form.Select aria-label="Default select example" className='DropdowonNavbar'>
      <option>Health</option>
      <option value="1">One</option>
      <option value="2">Two</option>
      <option value="3">Three</option>
    </Form.Select>
  );
}

export default HealthDropdown;