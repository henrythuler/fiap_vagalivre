using System.ComponentModel.DataAnnotations;

namespace api.Models;

public record LoginInputModel
{
    [Required]
    [EmailAddress]
    public string Email{ get; set; }
    
    [Required]
    public string Password { get; set; }
}