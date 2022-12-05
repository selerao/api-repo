package br.com.excaladashboard.services.jobs;

import br.com.excaladashboard.services.facebook.FacebookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class FacebookScheduleJob {

    private static final String CRON = "0 0/4 * 1/1 * *";

    private static final Logger LOG = LoggerFactory.getLogger(FacebookScheduleJob.class);

    @Autowired
    private FacebookService facebookService;

    @Scheduled(cron = CRON)
    public void executeJob() {
        // aqui deve ficar o serviço que popula os dados da API do facebook
        this.facebookService.atualizarDados();
    }

}
