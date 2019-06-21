package ar.com.jsl.plantapotabilizadora.business;

import ar.com.jsl.plantapotabilizadora.model.AuthToken;

public interface IAuthTokenBusiness {
	public AuthToken save(AuthToken at) throws BusinessException;

	public AuthToken load(String series) throws BusinessException, NotFoundException;

	public void delete(AuthToken at) throws BusinessException;
}