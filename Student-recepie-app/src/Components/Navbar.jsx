import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

function RecepieNavbar() {
  return (
    <Navbar expand="lg" className="RecepieNavbar">
      <Container>
        <Navbar.Brand href="#home"  className='TitleName'>Frugal Feast</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="#link" style={{color: "#f1f4f0"}}>My recepies</Nav.Link>
          </Nav>
        </Navbar.Collapse>
        <Navbar.Collapse className="justify-content-end">
          {/* <NavDropdown title="Link" id="navbarScrollingDropdown">
              <NavDropdown.Item href="#action3">Login</NavDropdown.Item>
              <NavDropdown.Item href="#action4">
                Sign Up
              </NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action5">
                Something else here
              </NavDropdown.Item>
            </NavDropdown> */}
          {/* <Navbar.Text style={{color: "#f1f4f0"}}>
            Signed in as: <a href="#login" style={{color: "#f1f4f0"}}>Troy Barnes</a>
          </Navbar.Text> */}
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default RecepieNavbar;