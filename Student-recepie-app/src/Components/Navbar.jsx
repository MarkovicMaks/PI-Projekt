import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

function RecepieNavbar() {
  return (
    <Navbar expand="lg" className="RecepieNavbar">
      <Container>
        <Navbar.Brand href="#home" style={{color: "#f1f4f0"}}>Frugal Feast</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="#link" style={{color: "#f1f4f0"}}>Meal Plans</Nav.Link>
          </Nav>
        </Navbar.Collapse>
        <Navbar.Collapse className="justify-content-end">
          <Navbar.Text style={{color: "#f1f4f0"}}>
            Signed in as: <a href="#login" style={{color: "#f1f4f0"}}>Troy Barnes</a>
          </Navbar.Text>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default RecepieNavbar;