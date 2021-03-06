package upm.miw.pfm.controllers;

import java.util.List;

import upm.miw.pfm.models.entities.Contract;

public interface ContractController {

    public void saveContract(Contract contract);

    public boolean existContract(Contract contract);

    public List<Contract> contractList();

    public Contract getContract(int selectedContractId);

	public void update(Contract contract);

	public boolean delete(Integer id);
}
