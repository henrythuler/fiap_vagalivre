using api.Models;
using Microsoft.AspNetCore.Mvc;

namespace api.Controllers;

[ApiController]
[Route("v1/users")]
public class UserController : ControllerBase
{
    private readonly List<User> _users =
    [
        new User { Email = "felipe@email.com", Name = "Felipe Gandra", Password = "felipe123" },
        new User { Email = "bianca@email.com", Name = "Bianca Ravani", Password = "bianca123" },
        new User { Email = "henry@email.com", Name = "Henry Thuler", Password = "henry123" }
    ];
    
    [HttpPost("login")]
    public IActionResult Login([FromBody]LoginInputModel model)
    {
        var user = _users.FirstOrDefault(x => x.Email == model.Email);

        if (user is null || user.Password != model.Password)
            return BadRequest("User not found or incorrect password");

        return Ok(user.Name);
    }
    
}