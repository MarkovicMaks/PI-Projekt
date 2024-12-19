import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import CardTitle from "react-bootstrap/esm/CardTitle";

function RegertrationWindow() {
  return (
    <Card style={{ width: "18rem" }} className="LoginContainer">
      <Card.Body>
        <CardTitle>Sign Up</CardTitle>
        <Form>
          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label style={{color: "#f1f4f0"}}>Username</Form.Label>
            <Form.Control type="Username" placeholder="Enter Username" className="LoginInput" style={{color: "#f1f4f0"}}/>
          </Form.Group>

          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label style={{color: "#f1f4f0"}}>Password</Form.Label>
            <Form.Control type="password" placeholder="Password" className="LoginInput" style={{color: "#f1f4f0"}}/>
          </Form.Group>
          <Button variant="primary" type="submit" className="GenericButon">
            Submit
          </Button>
        </Form>
      </Card.Body>
    </Card>
  );
}

export default RegertrationWindow;
