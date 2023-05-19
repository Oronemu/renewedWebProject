package web.application.token;

class Token implements IToken {

    private ISender sender;
    private ITokenService tokenService;

    @Override
    public void create(String username) {
        sender.sendToken(tokenService.create(username));
    }

    @Override
    public void check(String username, String token) {
        sender.sendCheck(tokenService.check(username, token));
    }

    @Override
    public void setSender(ISender sender) {
        this.sender = sender;
    }

    @Override
    public void setTokenService(ITokenService tokenService) {
        this.tokenService = tokenService;
    }
    
}